package org.example.Commands;

import org.example.Menegers.CollectionManager;
import org.example.MusicBands.MusicBand;
import org.example.Utility.MusicBandBuilder;

import java.io.IOException;

public class Remove_lower extends AbstractCommand{

    CollectionManager collectionManager;

    public Remove_lower(CollectionManager collectionManager) {
        super("rml", "remove_lower: удалить из коллекции все элементы, меньшие, чем заданный");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String... args) throws IOException, ClassNotFoundException {
        MusicBand element = MusicBandBuilder.buildMusicBandByNoArgs(null);
        collectionManager.getCollections().removeAll(collectionManager.getMusicBandsByParam(element));
    }
}
