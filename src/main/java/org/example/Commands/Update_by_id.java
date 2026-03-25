package org.example.Commands;

import org.example.Menegers.CollectionManager;
import org.example.MusicBands.MusicBand;
import org.example.Utility.Console;
import org.example.Utility.MusicBandBuilder;

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
            MusicBand musicBand = collectionManager.getMusicBandByID(id);
            MusicBandBuilder.MusicBandUpdater(musicBand);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Некорректное значение id: " + e.getMessage());
        }
    }
}
