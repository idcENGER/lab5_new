package org.example.Utility;

import org.example.Commands.*;
import org.example.Menegers.CollectionManager;
import org.example.Menegers.CommandInvoker;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class Console {

    public static String[] args;

    public static void run() throws IOException {
        CollectionManager collectionManager = new CollectionManager();
        CommandInvoker commandInvoker = new CommandInvoker();
        Scanner scanner = new Scanner(System.in);
        commandInvoker.register(new Help(commandInvoker));
        commandInvoker.register(new Info(collectionManager));
        commandInvoker.register(new Clear(collectionManager));
        commandInvoker.register(new Exit());
        commandInvoker.register(new Show(collectionManager));
        commandInvoker.register(new Add(collectionManager));
        commandInvoker.register(new Save(collectionManager, Path.of("data.xml")));
        commandInvoker.register(new Remove_by_id(collectionManager));
        commandInvoker.register(new Update_by_id(collectionManager));
        collectionManager.recoverCollection("data.xml");
        System.out.println("Welcome to Lab5APP. Enter help to get command list.");
        while (true){
            System.out.print("=>");
            String command = XmlHandler.SpaceRemover(scanner.nextLine());
            args = command.split(" ", 2);
            String commandName = args[0];
            if (args[0].isBlank()){continue;}
            if(args[0].equals("add") | args[0].equals("remove_by_id")){
                commandInvoker.execute(commandName);
            }else {commandInvoker.execute(command);}
        }
    }
}

