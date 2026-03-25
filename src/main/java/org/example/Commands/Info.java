package org.example.Commands;

import org.example.Menegers.CollectionManager;
import org.example.Utility.Console;

public class Info extends AbstractCommand{

    CollectionManager collectionManager;

    public Info(CollectionManager collectionManager) {
        super("info", "вывести в стандартный поток вывода информацию о коллекции");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String... args) {
        try {
            if(Console.args.length > 1){
                throw new ArrayIndexOutOfBoundsException("Команда не поддерживает аргументы");
            }
            System.out.println(collectionManager.toString());
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }

}
