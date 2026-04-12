package org.example.Utility;

import org.example.MusicBands.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Scanner;

public class ScannerParser {

    private static String extractTag(String xml, String tag) {
        String openTag = "<" + tag + ">";
        String closeTag = "</" + tag + ">";
        int start = xml.indexOf(openTag);
        int end = xml.indexOf(closeTag);
        if (start == -1 || end == -1) return null;
        return xml.substring(start + openTag.length(), end).trim();
    }

    public static HashSet<MusicBand> DeserializeCollectionXML(String dataPath) throws IOException {
        HashSet<MusicBand> collection = new HashSet<>();
        File file = new File(dataPath);
        if (!file.exists() || !file.canRead()) {
            return collection;
        }

        StringBuilder contentBuilder = new StringBuilder();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                contentBuilder.append(scanner.nextLine().trim());
            }
        }
        String content = contentBuilder.toString();

        String openBand = "<MusicBand>";
        String closeBand = "</MusicBand>";
        int searchIndex = 0;

        while (true) {
            int start = content.indexOf(openBand, searchIndex);
            if (start == -1) break;
            int end = content.indexOf(closeBand, start);
            if (end == -1) break;

            String bandXml = content.substring(start + openBand.length(), end);
            searchIndex = end + closeBand.length();

            try {
                String idStr = extractTag(bandXml, "id");
                Integer id = idStr != null ? Integer.parseInt(idStr) : 0;

                String name = extractTag(bandXml, "name");

                String coordinatesStr = extractTag(bandXml, "coordinates");
                Coordinates coordinates = null;
                if (coordinatesStr != null) {
                    int cx = Integer.parseInt(extractTag(coordinatesStr, "x"));
                    Double cy = Double.parseDouble(extractTag(coordinatesStr, "y"));
                    coordinates = new Coordinates(cx, cy);
                }

                ZonedDateTime creationDate = ZonedDateTime.parse(extractTag(bandXml, "creationDate"));
                Long numberOfParticipants = Long.parseLong(extractTag(bandXml, "numberOfParticipants"));
                LocalDate establishmentDate = LocalDate.parse(extractTag(bandXml, "establishmentDate"));

                String genreStr = extractTag(bandXml, "genre");
                MusicGenre genre = genreStr != null && !genreStr.isEmpty() && !genreStr.equals("null") ? MusicGenre.valueOf(genreStr) : null;

                String frontManStr = extractTag(bandXml, "frontMan");
                Person frontMan = null;
                if (frontManStr != null && !frontManStr.isEmpty()) {
                    String pName = extractTag(frontManStr, "name");

                    String heightStr = extractTag(frontManStr, "height");
                    Float height = heightStr != null && !heightStr.equals("null") ? Float.parseFloat(heightStr) : null;

                    String passportID = extractTag(frontManStr, "passportID");
                    if ("null".equals(passportID)) passportID = null;

                    String colorStr = extractTag(frontManStr, "hairColor");
                    Color hairColor = colorStr != null && !colorStr.equals("null") ? Color.valueOf(colorStr) : null;

                    String locationStr = extractTag(frontManStr, "location");
                    Location location = null;
                    if (locationStr != null && !locationStr.isEmpty() && !locationStr.equals("null")) {
                        double lx = Double.parseDouble(extractTag(locationStr, "x"));
                        long ly = Long.parseLong(extractTag(locationStr, "y"));
                        float lz = Float.parseFloat(extractTag(locationStr, "z"));
                        location = new Location(lx, ly, lz);
                    }

                    frontMan = new Person(pName, height, passportID, hairColor, location);
                }

                MusicBand band = new MusicBand(id, name, coordinates, creationDate, numberOfParticipants, establishmentDate, genre, frontMan);
                collection.add(band);
            } catch (Exception e) {
                System.out.println("Ошибка парсинга элемента: " + e.getMessage());
            }
        }
        return collection;
    }

    public static String SerializeXML(HashSet<MusicBand> collection) {
        StringBuilder xml = new StringBuilder();
        xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        xml.append("<HashSet>\n");
        for (MusicBand band : collection) {
            xml.append("  <MusicBand>\n");
            xml.append("    <id>").append(band.getId()).append("</id>\n");
            xml.append("    <name>").append(band.getName() != null ? band.getName() : "").append("</name>\n");

            xml.append("    <coordinates>\n");
            if (band.getCoordinates() != null) {
                xml.append("      <x>").append(band.getCoordinates().getX()).append("</x>\n");
                xml.append("      <y>").append(band.getCoordinates().getY()).append("</y>\n");
            }
            xml.append("    </coordinates>\n");

            xml.append("    <creationDate>").append(band.getCreationDate().toString()).append("</creationDate>\n");
            xml.append("    <numberOfParticipants>").append(band.getNumberOfParticipants()).append("</numberOfParticipants>\n");
            xml.append("    <establishmentDate>").append(band.getEstablishmentDate().toString()).append("</establishmentDate>\n");

            xml.append("    <genre>").append(band.getGenre() != null ? band.getGenre().name() : "null").append("</genre>\n");

            xml.append("    <frontMan>\n");
            if (band.getFrontMan() != null) {
                xml.append("      <name>").append(band.getFrontMan().getName()).append("</name>\n");
                xml.append("      <height>").append(band.getFrontMan().getHeight() != null ? band.getFrontMan().getHeight() : "null").append("</height>\n");
                xml.append("      <passportID>").append(band.getFrontMan().getPassportID() != null ? band.getFrontMan().getPassportID() : "null").append("</passportID>\n");
                xml.append("      <hairColor>").append(band.getFrontMan().getHairColor() != null ? band.getFrontMan().getHairColor().name() : "null").append("</hairColor>\n");

                xml.append("      <location>\n");
                if (band.getFrontMan().getLocation() != null) {
                    xml.append("        <x>").append(band.getFrontMan().getLocation().getX()).append("</x>\n");
                    xml.append("        <y>").append(band.getFrontMan().getLocation().getY()).append("</y>\n");
                    xml.append("        <z>").append(band.getFrontMan().getLocation().getZ()).append("</z>\n");
                } else {
                    xml.append("null");
                }
                xml.append("      </location>\n");
            }
            xml.append("    </frontMan>\n");

            xml.append("  </MusicBand>\n");
        }
        xml.append("</HashSet>\n");
        return xml.toString();
    }

    public static String SpaceRemover(String message){
        while (message.startsWith(" ") || message.startsWith("\t")){
            if (message.startsWith(" ")) {message = message.replaceFirst(" ","");}
            if (message.startsWith("\t")) {message = message.replaceFirst("\t","");}
        }
        return message;
    }
}