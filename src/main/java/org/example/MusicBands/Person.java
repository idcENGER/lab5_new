package org.example.MusicBands;

public class Person {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Float height; //Поле может быть null, Значение поля должно быть больше 0
    private String passportID; //Строка не может быть пустой, Значение этого поля должно быть уникальным, Длина строки не должна быть больше 22, Поле может быть null
    private Color hairColor; //Поле может быть null
    private Location location; //Поле может быть null

    public Person(String name,Float height,String passportID,Color hairColor,Location location){
        this.name = name;
        this.hairColor = hairColor;
        this.height = height;
        this.passportID = passportID;
        this.location = location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public void setPassportID(String passportID) {
        this.passportID = passportID;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setHairColor(Color hairColor) {
        this.hairColor = hairColor;
    }

    @Override
    public String toString(){
        return getClass().getSimpleName()+"{ NAME: " + name + ", HEIGHT: " + height + ", PASSPORT ID: " + passportID +
                ", HAIR COLOR: " + hairColor + ", " + location.toString() + "}";
    }
}
