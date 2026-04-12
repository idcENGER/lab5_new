package org.example.Commands;

import org.example.Menegers.CollectionManager;
import org.example.MusicBands.MusicBand;
import org.example.Utility.MusicBandBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Add extends AbstractCommand{
    CollectionManager collectionManager;

    public Add(CollectionManager collectionManager) {
        super("add","добавить новый элемент в коллекцию");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String... args) throws IOException {
        try {
            if (args.length == 0){
                collectionManager.add(MusicBandBuilder.buildMusicBandByNoArgs(collectionManager));
                System.out.println("Музыкальная группа успешно добавлена");
            }else{
                ArrayList<String> params = new ArrayList<>();
                for (String argument: args){
                    String[] s = argument.split(";");
                    params.addAll(Arrays.asList(s));
                }
                if(params.size() != 9){
                    throw new ArrayIndexOutOfBoundsException("Неверное количество аргументов");
                }
                MusicBand musicBand = MusicBandBuilder.buildMusicBandByParams(collectionManager,params);
                if (musicBand == null){
                    throw new NullPointerException("Неверный аргумент");
                }
                collectionManager.add(musicBand);
                System.out.println("Музыкальная группа успешно добавлена");
            }
        }catch (IllegalArgumentException | NullPointerException ex){
            System.out.println("Музыкальная группа не добавлена: " + ex.getMessage());
        }
    }
}
