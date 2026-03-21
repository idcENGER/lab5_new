package org.example.Utility;

import org.example.MusicBands.Coordinates;
import org.example.MusicBands.MusicBand;
import org.example.MusicBands.MusicGenre;
import org.example.MusicBands.Person;
import java.time.ZonedDateTime;
import java.util.Scanner;


public class MusicBandBuilder {
    MusicBand musicBand;
    Scanner scanner = new Scanner(System.in);

    public MusicBand buildMuisicBandByNoArgs() throws NullPointerException{
        try {
            return new MusicBand(askName(),askCoordinates());
        } catch (NullPointerException ex){
            ex.getMessage();
        }
        return null;
    }

    String askName(){
        System.out.print("Введите имя музыкальной группы:") ;
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
        return null;
    };
    private MusicGenre askGenre(){
        return null;
    }
    private Person askFrontMan(){
        return null;
    }

    public MusicBand buildMuisicBandByArgs() throws NullPointerException{
        String[] args = Console.args;
        //return new MusicBand();
        return null;
    }
}
