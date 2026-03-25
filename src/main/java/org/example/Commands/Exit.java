package org.example.Commands;

import org.example.Utility.Console;

public class Exit extends AbstractCommand{

    public Exit() {
        super("exit","завершить программу");
    }

    @Override
    public void execute(String... args) {
        try {
            if(Console.args.length > 1){
                throw new ArrayIndexOutOfBoundsException("Команда не поддерживает аргументы");
            }
            System.out.print("exit");
            System.exit(1);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }

    }
}
