package org.example.Commands;

import java.io.IOException;

public class Filter_contains_name extends AbstractCommand {

    public Filter_contains_name() {
        super("filter_contains_name", "вывести элементы, значение поля name которых содержит заданную подстроку");
    }

    @Override
    public void execute(String... args) throws IOException, ClassNotFoundException {

    }
}
