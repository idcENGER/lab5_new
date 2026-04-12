package org.example.Menegers;

import org.example.Exceptions.WrongArgumentException;
import org.example.MusicBands.*;
import org.example.Utility.Console;
import org.example.Utility.ScannerParser;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.HashSet;

public class CollectionManager {

    private final java.time.ZonedDateTime date = ZonedDateTime.now();
    private final HashSet<MusicBand> collections = new HashSet<>();


    public void add(MusicBand musicBand){
        collections.add(musicBand);
    }
    public void clear(){
        collections.clear();
    }

    public HashSet<MusicBand> getCollections(){
        return collections;
    }

    public int getSize(){
        return collections.size();
    }

    public void recoverCollection(String path) throws IOException,NullPointerException {
        HashSet<MusicBand> data = ScannerParser.DeserializeCollectionXML(path);
        collections.addAll(data);
    }

    public MusicBand getMusicBandByID(int id){
        try {
            for (MusicBand musicBand : collections) {
               if (musicBand.getId() == id){
                   return musicBand;
               }
            }
        }catch (NullPointerException ex){
            System.out.println("Collection is empty");
        }
        System.out.println("Музыкальной группы с таким id нет");
        return null;
    }

    public HashSet<MusicBand> getGreaterMusicBandByName(String name){
        HashSet<MusicBand> set = new HashSet<>();
        try {
            for (MusicBand musicBand : collections) {
                if (name.compareTo(musicBand.getName()) > 0){
                    set.add(musicBand);
                }
            }
            return set;
        }catch (NullPointerException ex){
            System.out.println("Collection is empty");
            return null;
        }
    }

    public HashSet<MusicBand> getGreaterMusicBandByCoordinates(Coordinates coordinates){
        HashSet<MusicBand> set = new HashSet<>();
        try {
            for (MusicBand musicBand : collections) {
                if (coordinates.compareTo(musicBand.getCoordinates()) > 0){
                    set.add(musicBand);
                }
            }
            return set;
        }catch (NullPointerException ex){
            System.out.println("Collection is empty");
            return null;
        }
    }

    public HashSet<MusicBand> getGreaterMusicBandByFrontMan(Person person){
        HashSet<MusicBand> set = new HashSet<>();
        try {
            for (MusicBand musicBand : collections) {
                int compResult = person.compareTo(musicBand.getFrontMan());
                if (compResult > 0){
                    set.add(musicBand);
                }
            }
            System.out.println(set);
            return set;
        }catch (NullPointerException ex){
            System.out.println("Collection is empty");
            return null;
        }
    }

    public HashSet<MusicBand> getMusicBandByNumberOfParticipants(long num){
        HashSet<MusicBand> set = new HashSet<>();
        try {
            for (MusicBand musicBand : collections) {
                if (num - musicBand.getNumberOfParticipants() > 0){
                    set.add(musicBand);
                }
            }
            return set;
        }catch (NullPointerException ex){
            System.out.println("Collection is empty");
            return null;
        }
    }

    /*
    * @params MusicGenre
    * this method compare Enum elements by there order
    * if order our genre greater than genre current MusicBand then current MusicBand append to set
    * if method found such genres then @return HashSet<MusicBand>
    * if collection is empty then @return null
    */
    public HashSet<MusicBand> getGreaterMusicBandByGenre(MusicGenre genre){
        HashSet<MusicBand> set = new HashSet<>();
        try {
            for (MusicBand musicBand : collections) {
                if (genre.compareTo(musicBand.getGenre()) > 0){
                    set.add(musicBand);
                }
            }
            System.out.println(set);
            return set;
        }catch (NullPointerException ex){
            System.out.println("Collection is empty");
            return null;
        }
    }

    public HashSet<MusicBand> getMusicBandsByParam(MusicBand element) throws WrongArgumentException {
        boolean validParam = false;
        String[] PARAMS = {"name","id","coordinates", "numberOfParticipants","genre","frontman"};
        try {
            String[] arguments = Console.args[1].split(" ");
            String param = arguments[0];
            for (String i: PARAMS){
                if (param.equals(i)){
                    validParam = true;
                    break;
                }
            }

            try {
                if(!validParam){
                    throw new WrongArgumentException("У музыкальной группы нет такого параметра");
                }
                switch (param){
                    case "name" -> {
                        return getGreaterMusicBandByName(element.getName());
                    }
                    case  "id" -> {
                        HashSet<MusicBand> set = new HashSet<>();
                        set.add(getMusicBandByID(Integer.parseInt("1")));
                        return set;
                    }
                    case "coordinates" -> {
                        Coordinates value = element.getCoordinates();
                        return getGreaterMusicBandByCoordinates(value);
                    }
                    case "numberOfParticipants" -> {
                        return getMusicBandByNumberOfParticipants(element.getNumberOfParticipants());
                    }
                    case "genre" -> {
                        return getGreaterMusicBandByGenre(element.getGenre());
                    }
                    case "frontman" ->{
                        return getGreaterMusicBandByFrontMan(element.getFrontMan());
                    }
                }
            System.out.println("Музыкальной группы с таким именем нет");
            return null;
        }catch (WrongArgumentException exception){
            System.out.println(exception.getMessage());
            return null;
            }
        }catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("Неверное количество аргументов команды");
            return null;
        }
    }

    public MusicBand filterMusicBandByName(String name,boolean start_with){
        try {
            if (!start_with){
                for (MusicBand musicBand : collections) {
                    if (musicBand.getName().contains(name)) {
                        return musicBand;
                    }
                    throw new NullPointerException("группы с таким именем не нашлось");
                }
            }else {
                for (MusicBand musicBand : collections) {
                    if (musicBand.getName().startsWith(name)) {
                        return musicBand;
                    }
                }
                throw new NullPointerException("Группы с таким именем не нашлось");
            }
        }catch (NullPointerException ex){
            System.out.println(ex.getMessage());
            return null;
        }
        return null;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{size:" + collections.size() + ", дата инициализации: " +
                date + "}";
    }
}