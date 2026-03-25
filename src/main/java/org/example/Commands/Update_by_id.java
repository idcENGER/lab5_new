package org.example.Commands;

import org.example.Menegers.CollectionManager;
import org.example.Utility.Console;

public class Update_by_id extends AbstractCommand{
    CollectionManager collectionManager;

    public Update_by_id(CollectionManager collectionManager) {
        super("update_by_id", "обновить значение элемента коллекции, id которого равен заданному");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String... args) {
        try {
            int id = Integer.parseInt(Console.args[1]);
            collectionManager.getMusicBandByID(id);
        } catch (NumberFormatException e) {
            System.out.println("Некорректное значение id" + e.getMessage());
        }
    }
}
