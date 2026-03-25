package org.example.Utility;

import com.thoughtworks.xstream.mapper.CannotResolveClassException;
import org.example.Exceptions.CastToException;
import org.example.Menegers.CollectionManager;
import org.example.MusicBands.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Scanner;


public class MusicBandBuilder {
    static Scanner scanner = new Scanner(System.in);

    public static MusicBand buildMusicBandByNoArgs(CollectionManager collectionManager) throws NullPointerException{
        try {
            ZonedDateTime creationDate = ZonedDateTime.now();
            LocalDate establishmentDate = LocalDate.now();
            Integer id = collectionManager.getSize()+1;
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
                String[] coordinates = XmlHandler.SpaceRemover(scanner.nextLine()).split(",");
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
            System.out.println("Введите жанр музыки: ");
            try {
                String genre = XmlHandler.SpaceRemover(scanner.nextLine());
                return MusicGenre.valueOf(genre);
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

    public static MusicBand buildMusicBandByFile(String path) throws IOException {
        try {
            return XmlHandler.DeserializeMusicBandXMLXStream(path);
        }catch (CastToException | CannotResolveClassException exception){
            System.out.println("Cant cast file data to HashSet<MusicBand> or file is empty");
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
