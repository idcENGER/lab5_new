package org.example.Commands;

import org.example.Menegers.CollectionManager;
import org.example.Utility.XmlHandler;

import java.util.Arrays;

public class Filter_contains_name extends AbstractCommand {
    CollectionManager collectionManager;
    public Filter_contains_name(CollectionManager collectionManager) {
        super("fcn", "filter_contains_name: вывести элементы," +
                " значение поля name которых содержит заданную подстроку");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String... args){
        System.out.println(Arrays.toString(args));
        try{
            if(args.length == 0){
                throw new ArrayIndexOutOfBoundsException("Аргумент не может быть равен нулю");
            }
            System.out.println(collectionManager.filterMusicBandByName(XmlHandler.SpaceRemover(args[0]),false).toString());
        }catch (ArrayIndexOutOfBoundsException ex){
            System.out.println(ex.getMessage());
        }
    }
}
