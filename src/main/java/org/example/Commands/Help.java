package org.example.Commands;

import org.example.Menegers.CommandInvoker;

public class Help extends AbstractCommand{

    CommandInvoker commandInvoker;

    public Help(CommandInvoker commandInvoker) {
        super("help", "вывести справку по доступным командам");
        this.commandInvoker = commandInvoker;
    }

    @Override
    public void execute(String... args) {
        for (var value : this.commandInvoker.getCommandMap().values()) {
            System.out.println(value.getDescription());
        }
    }
}
