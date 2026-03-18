package org.example.MusicBands;

public class Coordinates {
    private int x;
    private Double y; //Значение поля должно быть больше -147, Поле не может быть null

    public Coordinates(int x, Double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString(){
        return getClass().getSimpleName() + "{" + x + ", " + y + "}";
    }

}
