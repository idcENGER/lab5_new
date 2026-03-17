package org.example.Commands;

public class Update extends AbstractCommand{

    public Update(String name, String description) {
        super("update", "обновить значение элемента коллекции, id которого равен заданному");
    }

    @Override
    public void execute(String... args) {

    }
}
