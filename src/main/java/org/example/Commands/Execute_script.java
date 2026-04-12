package org.example.Commands;

import org.example.Menegers.CommandInvoker;
import org.example.Utility.XmlHandler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Execute_script extends AbstractCommand{

    CommandInvoker commandInvoker;

    public Execute_script(CommandInvoker commandInvoker) {
        super("execute", "description");
        this.commandInvoker = commandInvoker;
    }

    @Override
    public void execute(String... args) throws IOException {
        //execute /home/enger/scriptlab5
        try {
            if (args.length == 0){
                throw new ArrayIndexOutOfBoundsException("Аргумент не может быть равен нулю");
            }
            Path path = Path.of(args[0]);
            String content = Files.readString(path);
            String[] commands = content.split("\n");
            for (String command : commands){
                XmlHandler.SpaceRemover(command);
                if (command.contains(" ")){
                    String commandName = command.split(" ")[0];
                    ArrayList<String> list = new ArrayList<>(List.of(command.split(" ")));
                    list.remove(0);
                    String[] arguments = list.toArray(new String[0]);
                    commandInvoker.executeScriptCommand(commandName,arguments);
                }else {
                    XmlHandler.AllSpaceRemover(command);
                    String[] arguments = {"1"};
                    commandInvoker.executeScriptCommand(command,arguments);
                }
            }
        }catch (ArrayIndexOutOfBoundsException | IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
