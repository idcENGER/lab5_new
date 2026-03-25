package org.example.Commands;

import java.io.IOException;

public class Filter_starts_with_name extends AbstractCommand{

    public Filter_starts_with_name(String name, String description) {
        super(name, description);
    }

    @Override
    public void execute(String... args) throws IOException, ClassNotFoundException {

    }
}
