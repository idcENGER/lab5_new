package org.example.Commands;

public class Exit extends AbstractCommand{
    public Exit() {
        super("exit","завершить программу");
    }

    @Override
    public void execute(String... args) {
        System.out.print("exit");
        System.exit(1);

    }
}
