package org.example.MusicBands;



public class MusicBand {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long numberOfParticipants; //Поле не может быть null, Значение поля должно быть больше 0
    private java.time.LocalDate establishmentDate; //Поле не может быть null
    private MusicGenre genre; //Поле может быть null
    private Person frontMan; //Поле не может быть null

    public MusicBand(Integer id, String name,Coordinates coordinates,java.time.ZonedDateTime creationDate,
                     Long numberOfParticipants,java.time.LocalDate establishmentDate,MusicGenre genre,Person frontMan){
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.numberOfParticipants = numberOfParticipants;
        this.establishmentDate = establishmentDate;
        this.genre = genre;
        this.frontMan = frontMan;
    }

    @Override
    public String toString(){
        return getClass().getSimpleName()+"{" + id + ", " + name + ", " + coordinates.toString() + ", " + creationDate + ", " +
                 numberOfParticipants + ", " + establishmentDate + ", " + genre + ", " + frontMan.toString() + "}";
    }
}
