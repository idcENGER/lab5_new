package org.example.Commands;

import org.example.Menegers.CollectionManager;
import org.example.Utility.MusicBandBuilder;
import org.example.Utility.Console;

import java.io.IOException;

public class Add extends AbstractCommand{
    CollectionManager collectionManager;

    public Add(CollectionManager collectionManager) {
        super("add","[-af] добавить новый элемент в коллекцию");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String... args) {
        args = Console.args;
        if (args.length == 1){
            collectionManager.add(MusicBandBuilder.buildMusicBandByNoArgs(collectionManager));
        }else {
            String[] arg = args[1].split(" ");
            String flag = arg[0];
            switch (flag){
                case "-f" -> {
                    try {
                        if (arg.length > 2 || arg.length == 1){
                            throw new ArrayIndexOutOfBoundsException("Команда не поддерживает столько аргументов");
                        }
                        collectionManager.add(MusicBandBuilder.buildMusicBandByFile(args[1].split(" ")[1]));
                    } catch (IOException e) {
                        System.out.println("Нет файла: " + "\"" +e.getMessage() + "\"");
                    }catch (ArrayIndexOutOfBoundsException exception){
                        System.out.println(exception.getMessage());
                    }
                }
                case "-a" -> collectionManager.add(MusicBandBuilder.buildMusicBandByNoArgs(collectionManager));
            }
        }
    }
}
