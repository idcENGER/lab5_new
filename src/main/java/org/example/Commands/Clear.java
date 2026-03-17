package org.example.Commands;

import org.example.Menegers.CollectionManager;

public class Clear extends AbstractCommand{

    CollectionManager collectionManager;

    public Clear() {
        super("clear", "очистить коллекцию");
    }

    @Override
    public void execute(String... args) {
        this.collectionManager.clear();
    }
}
