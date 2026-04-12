package org.example.Commands;

import org.example.Menegers.CollectionManager;
import org.example.MusicBands.MusicBand;
import org.example.Utility.MusicBandBuilder;

public class Add_if_min extends AbstractCommand{

    CollectionManager collectionManager;

    public Add_if_min(CollectionManager collectionManager) {
        super("aifm", "add_if_min: добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String... args) {
        try {
            if (args.length == 1){
                throw new ArrayIndexOutOfBoundsException("Аргумент не может быть равен нулю");
            }
            MusicBand newMusicBand = MusicBandBuilder.buildMusicBandByNoArgs(null);
            if (newMusicBand != null) {
                newMusicBand.setId(collectionManager.getCollections().size()+1);
            }
            if (collectionManager.getMusicBandsByParam(newMusicBand).isEmpty()){
                collectionManager.add(newMusicBand);
                System.out.println("Элемент добавлен.");
            }
        }catch (ArrayIndexOutOfBoundsException ex){
            System.out.println(ex.getMessage());
        }
    }
}
