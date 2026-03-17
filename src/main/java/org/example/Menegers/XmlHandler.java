package org.example.Menegers;

import com.thoughtworks.xstream.XStream;
import org.example.MusicBands.MusicBand;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class XmlHandler {
    public static void SerializeXMLXStream() throws IOException {
        XStream xStream = new XStream();
        xStream.allowTypes(new Class[] {MusicBand.class});
        String content = Files.readString(Paths.get("/home/enger/Projects/lab5_new/src/main/java/org/example/Test.xml"));
        xStream.alias("MusicBand",MusicBand.class);
        MusicBand musicBand = (MusicBand) xStream.fromXML(content);
        System.out.println(musicBand.toString());
    }



}
