package org.example.Commands;

import org.example.Menegers.CollectionManager;
import org.example.Utility.MusicBandBuilder;
import org.example.Utility.Console;

public class Add extends AbstractCommand{
    CollectionManager collectionManager;
    MusicBandBuilder builder;

    public Add(CollectionManager collectionManager, MusicBandBuilder builder) {
        super("add","[-af] добавить новый элемент в коллекцию");
        this.collectionManager = collectionManager;
        this.builder = builder;
    }

    @Override
    public void execute(String... args) {
        args = Console.args;
        if (args.length == 1){
            collectionManager.add(builder.buildMuisicBandByNoArgs());
        }else {
            switch (args[1]){
                case "-f" -> collectionManager.add(builder.buildMuisicBandByNoArgs()); //change the method
                case "-a" -> collectionManager.add(builder.buildMuisicBandByArgs());
            }
        }
        /*else{if(Console.args[1].equals("-f")){collectionManager.add(builder.buildMuisicBandByNoArgs());}
            else{if(Console.args[1].equals("-a")){collectionManager.add(builder.buildMuisicBandByArgs());}}
        }*/
    }
}
