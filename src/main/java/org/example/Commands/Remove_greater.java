package org.example.Commands;

import org.example.Menegers.CollectionManager;
import org.example.MusicBands.MusicBand;
import org.example.Utility.MusicBandBuilder;

public class Remove_greater extends AbstractCommand{

    CollectionManager collectionManager;

    public Remove_greater(CollectionManager collectionManager) {
        super("rmg", "remove_greater: удалить из коллекции все элементы, превышающие заданный");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String... args){
        MusicBand element = MusicBandBuilder.buildMusicBandByNoArgs(null);
        collectionManager.getCollections().retainAll(collectionManager.getMusicBandsByParam(element));
    }
}
