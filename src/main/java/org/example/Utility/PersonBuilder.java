package org.example.Utility;

import org.example.MusicBands.*;

import java.util.Scanner;

public class PersonBuilder {

    public static Person buildPerson(){
        return new Person(askName(),askHeight(),askPassportID(),askHairColor(),askLocation());
    }

    static Scanner scanner = new Scanner(System.in);

    private static String askName(){
        while (true){
            System.out.print("Введите имя артиста: ");
            try {
            String name = XmlHandler.SpaceRemover(scanner.nextLine());
            if (name.matches("^[A-ZА-ЯЁ][a-zа-яё]+(?:[- ][A-ZА-ЯЁ][a-zа-яё]+)*$")) {return name;}
        }catch (IllegalArgumentException e){
                System.out.println("В имени могут быть только буквы.");
            }
        }
    }

    private static Float askHeight(){
        float input;
        do {
            System.out.print("Введите рост артиста: ");
            try {
                input = Float.parseFloat(XmlHandler.SpaceRemover(scanner.nextLine()));
            }catch (NumberFormatException exception){
                System.out.println(exception.getMessage());
                input = 0f;
            }
        }while (input <= 0f || input >= 300f);
        return input;
    }

    private static String askPassportID() throws IllegalArgumentException {
        while (true){
            System.out.print("Введите пасспортные данные: ");
            try {
                String id = XmlHandler.SpaceRemover(scanner.nextLine());
                if (id.length() >22) {
                    throw new IllegalArgumentException("В пасспортных данных не больше 22 символов.");
                }
                if(id.isBlank()){
                    throw new NullPointerException("Строка не может быть пустой");
                }
                return id;
            }catch (NullPointerException | IllegalArgumentException e){
                System.out.println("Некорректные данные:" + e.getMessage());
            }
        }
    }

    private static Color askHairColor(){
        while (true){
            Color.colors();
            System.out.print("Введите цвет или его номер: ");
            try {
                String color = scanner.nextLine();
                if(color.matches("^[0-9]+")){
                    return Color.values()[Integer.parseInt(color)];
                }else{
                    return Color.valueOf(XmlHandler.SpaceRemover(color));
                }
            }catch (IllegalArgumentException | ArrayIndexOutOfBoundsException ex){
                System.out.println("Некорректный цвет. Попробуйте еще раз.");
            }
        }
    }

    private static Location askLocation(){
        while(true) {
            try {
                System.out.print("Введите координаты в формате x,y,z: ");
                String str = XmlHandler.SpaceRemover(scanner.nextLine());
                if (!str.substring(str.length()-1).matches("^[0-9]")){
                    throw new IllegalArgumentException();
                }
                String[] location = str.split(",");
                double x = Double.parseDouble(XmlHandler.SpaceRemover(location[0]));
                long y = Long.parseLong(XmlHandler.SpaceRemover(location[1]));
                float z = Float.parseFloat(XmlHandler.SpaceRemover(location[2]));
                return new Location(x,y,z);
            }catch (IllegalArgumentException | IndexOutOfBoundsException ex){
                System.out.println("Некорректные данные. " + ex.getMessage());
            }
        }

    }

    public static Person updatePerson(Person person){
        person.setName(askName());
        person.setHeight(askHeight());
        person.setPassportID(askPassportID());
        person.setHairColor(askHairColor());
        person.setLocation(askLocation());
        return person;
    }

}
