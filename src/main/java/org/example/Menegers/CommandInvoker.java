package org.example.Menegers;

import org.example.Commands.Command;

import java.util.HashMap;
import java.util.Map;

public class CommandInvoker {
    private static final Map<String, Command> commandMap = new HashMap<>();
    private org.example.Menegers.CollectionManager collectionManager;
    public CommandInvoker(org.example.Menegers.CollectionManager collectionManager)  {
        this.collectionManager = collectionManager;
    }
    public void register(Command command){
        commandMap.put(command.getName(), command);
    }
    public void execute(String commandName){
        commandMap.get(commandName).execute();
    }

    public static void getCommandMap(){
        for (var value: commandMap.values()){
           System.out.println(value.description());
        }
    }

}
