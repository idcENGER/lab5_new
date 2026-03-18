package org.example.Commands;

import org.example.Exceptions.WrongCommandException;
import org.example.Menegers.CommandInvoker;

public class Help extends AbstractCommand{

    CommandInvoker commandInvoker;

    public Help(CommandInvoker commandInvoker) {
        super("help", "вывести справку по доступным командам");
        this.commandInvoker = commandInvoker;
    }

    @Override
    public void execute(String... args) {
        try {
            if (!args[1].isEmpty()) throw new WrongCommandException();
            for (var value : this.commandInvoker.getCommandMap().values()) {
                System.out.println(value.getDescription());
            }
        }catch (WrongCommandException exception){
            System.out.println(exception.toString());
        }
    }
}
