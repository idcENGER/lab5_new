package org.example.Utility;

import org.example.Menegers.XmlHandler;
import org.example.MusicBands.Coordinates;
import org.example.MusicBands.MusicBand;
import org.example.MusicBands.MusicGenre;
import org.example.MusicBands.Person;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Scanner;


public class MusicBandBuilder {
    Scanner scanner = new Scanner(System.in);

    public MusicBand buildMusicBandByNoArgs() throws NullPointerException{
        try {
            ZonedDateTime creationDate = ZonedDateTime.now();
            LocalDate establishmentDate = LocalDate.now();
            return new MusicBand(askName(), askCoordinates(), creationDate, askNumberOfParticipants(),
                    establishmentDate);
        } catch (NullPointerException ex){
            ex.getMessage();
        }
        return null;
    }

    String askName(){
        System.out.print("Введите имя музыкальной группы: ") ;
        return scanner.nextLine();
    }

    private Coordinates askCoordinates() {
        System.out.print("Введите координату x: ");
        int x = Integer.parseInt(scanner.nextLine());
        System.out.print("Введите координату y(не меньше -147): ");
        double y = Double.parseDouble(scanner.nextLine());
        return new Coordinates(x,y);
    }

    private Long askNumberOfParticipants(){
        System.out.print("Введите число участников: ");
        return Long.parseLong(scanner.nextLine());
    }

    private MusicGenre askGenre(){
        return null;
    }
    private Person askFrontMan(){
        return null;
    }

    public MusicBand buildMusicBandByArgs() throws NullPointerException{
        String[] args = Console.args;
        //return new MusicBand();
        return null;
    }

    public MusicBand buildMusicBandByFile(String path) throws IOException {
        return XmlHandler.DeserializeXMLXStream(path);
    }

}
