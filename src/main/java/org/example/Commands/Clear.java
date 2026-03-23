package org.example.Commands;

import org.example.Menegers.CollectionManager;

public class Clear extends AbstractCommand{

    CollectionManager collectionManager;

    public Clear(CollectionManager collectionManager) {
        super("clear", "очистить коллекцию");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String... args) {
        collectionManager.clear();
    }
}
