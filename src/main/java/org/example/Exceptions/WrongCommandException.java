package org.example.Exceptions;

public class WrongCommandException extends Exception {
    @Override
    public String toString(){
        return getMessage();
    }
}
