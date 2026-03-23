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
        while (true){
            System.out.print("=>");
            String s = scanner.nextLine();
            while (s.startsWith(" ") || s.startsWith("\t")){
                if (s.startsWith(" ")) {s = s.replaceFirst(" ","");}
                if (s.startsWith("\t")) {s = s.replaceFirst("\t","");}
            }
            args = s.split(" ", 2);
            String commandName = args[0];
            if (args[0].isBlank()){continue;}
            commandInvoker.execute(commandName);
        }
    }
}

