package org.example.Utility;

import org.example.Menegers.CollectionManager;
import org.example.MusicBands.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Scanner;


public class MusicBandBuilder {
    static Scanner scanner = new Scanner(System.in);

    public static MusicBand buildMusicBandByNoArgs(CollectionManager collectionManager) throws NullPointerException{
        try {
            int id = 0;
            ZonedDateTime creationDate = ZonedDateTime.now();
            LocalDate establishmentDate = LocalDate.now();
            if (collectionManager != null) {
                id = collectionManager.getSize() + 1;}
            return new MusicBand(id,askName(), askCoordinates(), creationDate, askNumberOfParticipants(),
                    establishmentDate,askGenre(),askFrontMan(true,null));
        } catch (NullPointerException ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }

    private static String askName() throws IllegalArgumentException{
        while(true){
            try {
                System.out.print("Введите название музыкальной группы: ");
                String name = XmlHandler.SpaceRemover(scanner.nextLine());
                if (name.isBlank()){throw new IllegalArgumentException("Имя не может быть пустым");}
                return name;
            }catch (IllegalArgumentException ex){
                System.out.println("Ошибка! " + ex.getMessage());
            }
        }
    }

    private static Coordinates askCoordinates() throws IllegalArgumentException{
        while(true) {
            try {
                System.out.print("Введите координаты в формате x,y(не меньше -147): ");
                String str = XmlHandler.SpaceRemover(scanner.nextLine());
                if(!str.substring(str.length()-1).matches("^[0-9]")){
                    throw new IllegalArgumentException();
                }
                String[] coordinates = str.split(",");
                int x = Integer.parseInt(coordinates[0]);
                double y = Double.parseDouble(coordinates[1]);
                if (y <= -147) {
                    throw new IllegalArgumentException("Слишком маленькое значение для y = " + y);
                }else{
                    return new Coordinates(x, y);
                }
            }catch (IllegalArgumentException | IndexOutOfBoundsException ex){
                System.out.println("Некорректные данные. " + ex.getMessage());
            }
        }
    }

    private static Long askNumberOfParticipants(){
        System.out.print("Введите число участников: ");
        long n = 0L;
        try {
            n = Long.parseLong(XmlHandler.SpaceRemover(scanner.nextLine()));
        } catch (NumberFormatException ex) {
            System.out.println(ex.getMessage());
        }
        while (n <= 0L){
            System.out.print("Введено некорректное значение. Введите целое число участников: ");
            try {
                n = Long.parseLong(XmlHandler.SpaceRemover(scanner.nextLine()));
            }catch (NumberFormatException exception){
                System.out.println(exception.getMessage());
            }
        }
        return n;
    }

    private static MusicGenre askGenre(){
        while (true){
            MusicGenre.genre();
            System.out.print("Введите жанр музыки или её номер: ");
            try {
                String genre = scanner.nextLine();
                if(genre.matches("^[0-9]")){
                    return MusicGenre.values()[Integer.parseInt(genre)];
                }else{
                    return MusicGenre.valueOf(XmlHandler.SpaceRemover(genre));
                }
            }catch (IllegalArgumentException ex){
                System.out.println("Некорректный жанр. Попробуйте еще раз.");
            }
        }
    }
    private static Person askFrontMan(boolean newMusicBand,MusicBand musicBand){
        if(newMusicBand){
            return PersonBuilder.buildPerson();
        }else {
            return PersonBuilder.updatePerson(musicBand.getFrontMan());
        }
    }

    public static MusicBand buildMusicBandByParams(CollectionManager collectionManager, ArrayList<String> params) throws IOException {
        try {
            String[] c = XmlHandler.SpaceRemover(params.get(1)).split(",");
            String[] l = XmlHandler.SpaceRemover(params.get(8)).split(",");
            Location location = new Location(Double.parseDouble(l[0]), Long.parseLong(l[1]), Float.parseFloat(l[2]));
            Coordinates coordinates = new Coordinates(Integer.parseInt(c[0]), Double.parseDouble(c[1]));
            Color color = Color.valueOf(XmlHandler.SpaceRemover(params.get(7)));
            MusicGenre genre = MusicGenre.valueOf(XmlHandler.SpaceRemover(params.get(3)));
            Person frontMan = new Person(
                    XmlHandler.SpaceRemover(params.get(4)),
                    Float.parseFloat(XmlHandler.SpaceRemover(params.get(5))),
                    XmlHandler.SpaceRemover(params.get(6)),
                    color,
                    location
            );
            return new MusicBand(
                    collectionManager.getSize() + 1,
                    XmlHandler.SpaceRemover(params.get(0)),
                    coordinates,
                    ZonedDateTime.now(),
                    Long.parseLong(XmlHandler.SpaceRemover(params.get(2))),
                    LocalDate.now(),
                    genre,
                    frontMan
            );
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public static void MusicBandUpdater(MusicBand musicBand){
        musicBand.setName(askName());
        musicBand.setCoordinates(askCoordinates());
        musicBand.setCreationDate(ZonedDateTime.now());
        musicBand.setNumberOfParticipants(askNumberOfParticipants());
        musicBand.setEstablishmentDate(LocalDate.now());
        musicBand.setGenre(askGenre());
        musicBand.setFrontMan(askFrontMan(false,musicBand));
    }
}
