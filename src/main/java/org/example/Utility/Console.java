package org.example.Utility;

import org.example.Commands.*;
import org.example.Menegers.CollectionManager;
import org.example.Menegers.CommandInvoker;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class Console {

    public static String[] args;

    public static void run(String filename) throws IOException {
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
        commandInvoker.register(new Filter_contains_name(collectionManager));
        commandInvoker.register(new Filter_starts_with_name(collectionManager));
        commandInvoker.register(new Group_counting_by_creation_date(collectionManager));
        commandInvoker.register(new Add_if_min(collectionManager));
        commandInvoker.register(new Remove_greater(collectionManager));
        commandInvoker.register(new Remove_lower(collectionManager));
        commandInvoker.register(new Execute_script(commandInvoker));
        System.out.println("Welcome to Lab5APP. Enter help to get command list.");
        if (!collectionManager.recoverCollection(filename)){
            System.out.print("Некорректная коллекция: ID не уникальны");
            System.exit(0);
        }
        while (true){
            System.out.print("=>");
            String command = XmlHandler.SpaceRemover(scanner.nextLine());
            command = command.replace("\t", " ");
            args = command.split(" ",2);
            String commandName = args[0];
            XmlHandler.AllSpaceRemover(commandName);
            if (commandName.isBlank()){continue;}
            commandInvoker.execute(commandName);
        }
    }
}

