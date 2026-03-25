package org.example.Commands;

import org.example.Menegers.CollectionManager;
import org.example.Utility.Console;
import org.example.Utility.XmlHandler;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Path;

public class Save extends AbstractCommand{

    Path path;
    CollectionManager collectionManager;

    public Save(CollectionManager collectionManager, Path path){
        super("save", "сохранить коллекцию в файл");
        this.path = path;
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String... args) throws ClassNotFoundException {
        String data = XmlHandler.SerializeXMLXStream(collectionManager.getCollections());
        try{
            if(Console.args.length > 1){
                throw new ArrayIndexOutOfBoundsException("Команда не поддерживает аргументы");
            }
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(path.toString()));
            writer.write(data);
            writer.close();
        } catch (IOException | ArrayIndexOutOfBoundsException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
