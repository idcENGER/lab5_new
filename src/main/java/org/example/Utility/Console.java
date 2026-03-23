package org.example.Utility;

import org.example.Commands.*;
import org.example.Menegers.CollectionManager;
import org.example.Menegers.CommandInvoker;
import org.example.Menegers.XmlHandler;
import org.example.MusicBands.MusicBand;

import java.io.IOException;
import java.util.Scanner;

public class Console {

    public static String[] args;

    public static void run() throws IOException {
        CollectionManager collectionManager = new CollectionManager();
        CommandInvoker commandInvoker = new CommandInvoker(collectionManager);
        Scanner scanner = new Scanner(System.in);
        commandInvoker.register(new Help(commandInvoker));
        commandInvoker.register(new Info(collectionManager));
        commandInvoker.register(new Clear(collectionManager));
        commandInvoker.register(new Exit());
        commandInvoker.register(new Show(collectionManager));
        commandInvoker.register(new Add(collectionManager));
        while (true) {
            System.out.print("=>");
            args = scanner.nextLine().split(" ",2);
            if (args[0].isEmpty()){continue;}
            String commandName = args[0];
            commandInvoker.execute(commandName);
        }
    }
}

