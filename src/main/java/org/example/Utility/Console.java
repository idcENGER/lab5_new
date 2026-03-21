package org.example.Utility;

import org.example.Commands.*;
import org.example.Menegers.CollectionManager;
import org.example.Menegers.CommandInvoker;

import java.util.Arrays;
import java.util.Scanner;

public class Console {

    public static String[] args;

    public static void run(){
        CollectionManager collectionManager = new CollectionManager();
        CommandInvoker commandInvoker = new CommandInvoker(collectionManager);
        MusicBandBuilder builder = new MusicBandBuilder();
        Scanner scanner = new Scanner(System.in);
        commandInvoker.register(new Help(commandInvoker));
        commandInvoker.register(new Info());
        commandInvoker.register(new Clear(collectionManager));
        commandInvoker.register(new Exit());
        commandInvoker.register(new Show(collectionManager));
        commandInvoker.register(new Add(collectionManager, builder));
        System.out.print("=>");
        while (true) {
            args = scanner.nextLine().split(" ",2);
            System.out.println(Arrays.stream(args).toList());
            String commandName = args[0];
            commandInvoker.execute(commandName);
            System.out.print("=>");
        }
    }
}

