package org.example.Exceptions;

public class CastToException extends RuntimeException {

    public CastToException(String message){
        super(message);
    }

    @Override
    public String toString(){
        return getMessage();
    }
}
