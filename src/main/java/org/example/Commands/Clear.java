package org.example.Commands;

import org.example.Menegers.CollectionManager;

public class Clear implements org.example.Commands.Command {

    CollectionManager collectionManager;

    @Override
    public void execute(String... args) {
        this.collectionManager.clear();
    }

    @Override
    public String getName() {
        return "clear";
    }

    @Override
    public String description() {
        return getName()  + ": очистить коллекцию";
    }
}
