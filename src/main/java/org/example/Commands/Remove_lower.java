package org.example.Commands;

import java.io.IOException;

public class Remove_lower extends AbstractCommand{

    public Remove_lower() {
        super("remove_lower", "удалить из коллекции все элементы, меньшие, чем заданный");
    }

    @Override
    public void execute(String... args) throws IOException, ClassNotFoundException {

    }
}
