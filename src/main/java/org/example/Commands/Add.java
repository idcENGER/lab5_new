package org.example.Commands;

import org.example.Menegers.CollectionManager;
import org.example.MusicBands.MusicBand;
import org.example.Utility.Builder;

public class Add extends AbstractCommand{
    CollectionManager collectionManager;
    Builder builder;

    public Add(CollectionManager collectionManager, Builder builder) {
        super("add","добавить новый элемент в коллекцию");
        this.collectionManager = collectionManager;
        this.builder = builder;
    }

    @Override
    public void execute(String... args) {
        collectionManager.add(builder.buildMuisicBand());
    }
}
