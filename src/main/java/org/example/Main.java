package org.example;

import com.thoughtworks.xstream.XStream;
import org.example.Commands.Clear;
import org.example.Commands.Exit;
import org.example.Commands.Help;
import org.example.Commands.Info;
import org.example.Menegers.CommandInvoker;
import org.example.Menegers.CollectionManager;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        CollectionManager collectionManager = new CollectionManager();

        Scanner scanner = new Scanner(System.in);
        CommandInvoker commandInvoker = new CommandInvoker(collectionManager);
        commandInvoker.register(new Help());
        commandInvoker.register(new Info());
        commandInvoker.register(new Clear());
        commandInvoker.register(new Exit());

        class User {
            int id;
            java.lang.String name;
            public User(int i, String n) {
                id = i; name = n;
            }
        }
        User u = new User(1, "Ivan");

        while (true) {
            XStream xstream = new XStream();
            String xml = xstream.toXML(u);
            System.out.println(xml);
            User user = (User) xstream.fromXML(xml, User.class);
            System.out.println(user);
            String commandName = scanner.nextLine();
            commandInvoker.execute(commandName);
            System.out.print(":~$ ");
            if (commandName.equals("exit")){
                break;
            }
            if (commandName.equals("help")) {
                System.out.println("help");
            } else if (commandName.equals("add")) {
                System.out.println("add");
            } else if (commandName.equals("info")) {
                System.out.println("info");
            }
        }
    }
}
