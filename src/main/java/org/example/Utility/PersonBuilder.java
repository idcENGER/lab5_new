package org.example.Utility;

import org.example.MusicBands.Color;
import org.example.MusicBands.Coordinates;
import org.example.MusicBands.Location;
import org.example.MusicBands.Person;

import java.util.Scanner;

public class PersonBuilder {

    public static Person buildPerson(){
        return new Person(askName(),askHeight(),askPassportID(),askHairColor(),askLocation());
    }

    static Scanner scanner = new Scanner(System.in);

    private static String askName(){
        System.out.print("Введите имя артиста: ") ;
        return scanner.nextLine();
    }

    private static Coordinates askCoordinates() {
        System.out.print("Введите координату x: ");
        int x = Integer.parseInt(scanner.nextLine());
        System.out.print("Введите координату y(не меньше -147): ");
        double y = Double.parseDouble(scanner.nextLine());
        return new Coordinates(x,y);
    }

    private static Float askHeight(){
        float input;
        do {
            System.out.println("Введите рост артиста: ");
            input = Float.parseFloat(scanner.nextLine());
        }while (input <= 0f || input >= 300f);
        return input;
    }

    private static String askPassportID(){
        System.out.println("Введите пасспортные данные: ");
        //Строка не может быть пустой, Значение этого поля должно быть уникальным, Длина строки не должна быть больше 22, Поле может быть null
        return scanner.nextLine();
    }

    private static Color askHairColor(){
        System.out.println("Введите номер цвета волос артиста: ");
        Color.colors();
        return Color.values()[Integer.parseInt(scanner.nextLine())];
    }

    private static Location askLocation(){
        System.out.println("Определение локации");
        double x = Double.parseDouble(scanner.nextLine());
        long y = Long.parseLong(scanner.nextLine());
        float z = Float.parseFloat(scanner.nextLine());
        return new Location(x,y,z);

    }

}
