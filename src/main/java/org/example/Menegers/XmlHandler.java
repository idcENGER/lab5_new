package org.example.Menegers;

import com.thoughtworks.xstream.XStream;
import org.example.MusicBands.MusicBand;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class XmlHandler {
    public static MusicBand DeserializeXMLXStream(String dataPath) throws IOException {
        XStream xStream = new XStream();
        xStream.allowTypes(new Class[] {MusicBand.class});
        String content = Files.readString(Paths.get(dataPath));
        xStream.alias("MusicBand",MusicBand.class);
        return (MusicBand) xStream.fromXML(content);
    }
    public static String SerializeXMLXStream(MusicBand musicBand){
        XStream xStream = new XStream();
        return xStream.toXML(musicBand);
    }



}
