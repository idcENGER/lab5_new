package org.example.Commands;

public class Info implements org.example.Commands.Command{

    //CollectionManager

    @Override
    public void execute(String... args) {

    }

    @Override
    public String getName() {
        return "info";
    }

    @Override
    public String description() {
        return getName() + ": вывести в стандартный поток вывода информацию о коллекции ";
    }

}
