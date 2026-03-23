package org.example.Utility;

import org.example.Menegers.CollectionManager;
import org.example.Menegers.XmlHandler;
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
                    establishmentDate,askGenre(),askFrontMan());
        } catch (NullPointerException ex){
            System.err.println(ex.getMessage());
        }
        return null;
    }

    private static String askName() throws IllegalArgumentException{
        while(true){
            try {
                System.out.print("Введите название музыкальной группы: ");
                String name = scanner.nextLine();
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
                System.out.print("Введите координату x: ");
                int x = Integer.parseInt(scanner.nextLine());
                System.out.print("Введите координату y(не меньше -147): ");
                double y = Double.parseDouble(scanner.nextLine());
                if (y <= -147) {
                    throw new IllegalArgumentException("Слишком маленькое значение для y = " + y);
                }else{
                    return new Coordinates(x, y);
                }
            }catch (IllegalArgumentException ex){
                System.out.println("Некорректные данные. " + ex.getMessage());
            }
        }
    }

    private static Long askNumberOfParticipants(){
        System.out.print("Введите число участников: ");
        long n;
        n = Long.parseLong(scanner.nextLine());
        while (n <= 0L){
            System.out.print("Введено некорректное значение. Введите целое число участников: ");
            n = Long.parseLong(scanner.nextLine());
        }
        return n;
    }

    private static MusicGenre askGenre(){
        while (true){
            MusicGenre.genre();
            System.out.println("Введите номер жанра музыки: ");
            try {
                int index = Integer.parseInt(scanner.nextLine());
                return MusicGenre.values()[index];
            }catch (IndexOutOfBoundsException ex){
                System.out.println("Некорректный номер. Попробуйте еще раз.");
            }
        }
    }
    private static Person askFrontMan(){
        return PersonBuilder.buildPerson();
    }

    public static MusicBand buildMusicBandByArgs() throws NullPointerException{
        String[] args = Console.args;
        //return new MusicBand();
        return null;
    }

    public static MusicBand buildMusicBandByFile(String path) throws IOException {
        return XmlHandler.DeserializeXMLXStream(path);
    }

}
