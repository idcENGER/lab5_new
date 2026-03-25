package org.example.Commands;

import java.io.IOException;

public class Group_counting_by_creation_date extends AbstractCommand{

    public Group_counting_by_creation_date() {
        super("group_counting_by_creation_date", "сгруппировать элементы коллекции по значению поля creationDate," +
                " вывести количество элементов в каждой группе");
    }

    @Override
    public void execute(String... args) throws IOException, ClassNotFoundException {

    }
}
