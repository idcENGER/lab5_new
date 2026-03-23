package org.example.Commands;

import org.example.Menegers.CollectionManager;

public class Info extends AbstractCommand{

    CollectionManager collectionManager;

    public Info(CollectionManager collectionManager) {
        super("info", "вывести в стандартный поток вывода информацию о коллекции");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String... args) {
        System.out.println(collectionManager.toString());
    }

}
