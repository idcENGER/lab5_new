package org.example.Commands;

import org.example.Menegers.CollectionManager;
import org.example.Utility.Builder;
import org.example.Utility.Console;
import org.example.Utility.MusicBandBuilder;

public class Add extends AbstractCommand{
    CollectionManager collectionManager;
    Builder builder;

    public Add(CollectionManager collectionManager, MusicBandBuilder builder) {
        super("add","добавить новый элемент в коллекцию");
        this.collectionManager = collectionManager;
        this.builder = builder;
    }

    @Override
    public void execute(String... args) {
        if (Console.args.length == 1){
            //collectionManager.add(builder.buildMuisicBandByNoArgs());
            System.out.println("null");
        }else{
            if(Console.args[1].equals("-f")){
                //collectionManager.add(builder.buildMuisicBandByNoArgs());
                System.out.println("-f");
            }else{
                //collectionManager.add(builder.buildMuisicBandByArgs());
                System.out.println("args");
            }
        }
    }
}
