package org.example.Commands;

import org.example.Menegers.CollectionManager;
import org.example.Utility.Console;

public class Clear extends AbstractCommand{

    CollectionManager collectionManager;

    public Clear(CollectionManager collectionManager) {
        super("clear", "очистить коллекцию");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String... args) {
        try {
        if(Console.args.length > 1){
            throw new ArrayIndexOutOfBoundsException("Команда не поддерживает аргументы");
        }
            collectionManager.clear();
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }
}
