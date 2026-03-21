package org.example.Menegers;

import org.example.Commands.AbstractCommand;

import java.util.HashMap;
import java.util.Map;

public class CommandInvoker {
    private static final Map<String, AbstractCommand> commandMap = new HashMap<>();
    private org.example.Menegers.CollectionManager collectionManager;
    public CommandInvoker(org.example.Menegers.CollectionManager collectionManager)  {
        this.collectionManager = collectionManager;
    }
    public void register(AbstractCommand command){
        commandMap.put(command.getName(), command);
    }
    public void execute(String commandName) throws NullPointerException{
        try {
            commandMap.get(commandName).execute();
        }catch (NullPointerException ex){
            System.err.println("Unsupported command: " + ex.getMessage());
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public Map<String, AbstractCommand> getCommandMap(){
        return commandMap;
    }

}
