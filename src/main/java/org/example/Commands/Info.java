package org.example.Commands;

import org.example.Menegers.CollectionManager;

public class Info extends AbstractCommand{

    CollectionManager collectionManager;

    public Info() {
        super("info", "вывести в стандартный поток вывода информацию о коллекции");
    }




    @Override
    public void execute(String... args) {
        System.out.println(collectionManager.toString());
    }

}
