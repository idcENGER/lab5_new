package org.example.Commands;

import org.example.Menegers.CollectionManager;
import org.example.MusicBands.MusicBand;
import org.example.Utility.MusicBandBuilder;

public class Update_by_id extends AbstractCommand{
    CollectionManager collectionManager;

    public Update_by_id(CollectionManager collectionManager) {
        super("ubi", "update_by_id: обновить значение элемента коллекции, id которого равен заданному");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String... args) {
        try {
            String s = args[0].replace(" ","");
            s = s.replace("\t","");
            int id = Integer.parseInt(s);
            MusicBand musicBand = collectionManager.getMusicBandByID(id);
            if(musicBand != null){
                System.out.println("Обновление музыкальной группы");
                MusicBandBuilder.MusicBandUpdater(musicBand);
            }
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Некорректное значение id: " + e.getMessage());
        }
    }
}
