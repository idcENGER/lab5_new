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
            String flag = args[1].split(" ")[0];
            switch (flag){
                case "-f" -> {
                    try {
                        collectionManager.add(MusicBandBuilder.buildMusicBandByFile(args[1].split(" ")[1]));
                    } catch (IOException e) {
                        System.out.println("Нет файла: " + "\"" +e.getMessage() + "\"");
                    }
                }
                case "-a" -> collectionManager.add(MusicBandBuilder.buildMusicBandByArgs());
            }
        }
    }
}
