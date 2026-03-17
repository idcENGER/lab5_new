package org.example.Utility;

import org.example.Commands.Clear;
import org.example.Commands.Exit;
import org.example.Commands.Help;
import org.example.Commands.Info;
import org.example.Menegers.CollectionManager;
import org.example.Menegers.CommandInvoker;
import org.example.Menegers.XmlHandler;

import java.io.IOException;
import java.util.Scanner;

public class Runner {
    public static void run() throws IOException {
        CollectionManager collectionManager = new CollectionManager();
        CommandInvoker commandInvoker = new CommandInvoker(collectionManager);
        Scanner scanner = new Scanner(System.in);
        commandInvoker.register(new Help(commandInvoker));
        commandInvoker.register(new Info());
        commandInvoker.register(new Clear());
        commandInvoker.register(new Exit());
        XmlHandler.SerializeXMLXStream();
        System.out.print(":~$ ");
        while (true) {
            String commandName = scanner.nextLine();
            commandInvoker.execute(commandName);
            System.out.print(":~$ ");
            if (commandName.equals("exit")){
                break;
            }
            if (commandName.equals("help")) {
                System.out.print("");
            } else if (commandName.equals("add")) {
                System.out.print("");
            } else if (commandName.equals("")) {
                System.out.print("");
            }
        }
    }
}

