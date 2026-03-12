package org.example.Commands;

public class Exit implements Command{
    @Override
    public void execute(String... args) {

    }

    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public String description() {
        return getName()+": завершить программу";
    }
}
