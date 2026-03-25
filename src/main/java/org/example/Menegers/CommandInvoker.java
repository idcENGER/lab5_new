package org.example.Menegers;

import org.example.Commands.AbstractCommand;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.HashMap;
import java.util.Map;

public class CommandInvoker {

    private static final Map<String, AbstractCommand> commandMap = new HashMap<>();

    public void register(AbstractCommand command){
        commandMap.put(command.getName(), command);
    }
    public void execute(String commandName) throws NullPointerException, NoSuchFileException {
        try {
            commandMap.get(commandName).execute();
        }catch (NullPointerException ex){
            System.out.println("Unsupported command");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public Map<String, AbstractCommand> getCommandMap(){
        return commandMap;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
