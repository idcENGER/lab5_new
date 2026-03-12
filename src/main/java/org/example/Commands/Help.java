package org.example.Commands;

import org.example.Menegers.CommandInvoker;

public class Help implements org.example.Commands.Command {


    @Override
    public void execute(String... args){
        System.out.println("Command list:");
        CommandInvoker.getCommandMap();
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String description() {
        return getName()+": вывести справку по доступным командам";
    }



}
