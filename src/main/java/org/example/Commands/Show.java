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
        if (collectionManager.getSize() == 0){System.out.println("Коллекция пуста");}
        for (var i : collectionManager.getCollections()){
            System.out.println(i);
        }
    }
}
