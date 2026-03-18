package org.example.Commands;

import org.example.Menegers.CollectionManager;

public class Show extends AbstractCommand {

    CollectionManager collectionManager;

    public Show(CollectionManager collectionManager) {
        super("show", "показать информацию о коллекции");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String... args) {
        System.out.println(collectionManager.getCollections());
    }
}
