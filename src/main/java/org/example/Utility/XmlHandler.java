package org.example.Utility;

import org.example.MusicBands.MusicBand;

import com.thoughtworks.xstream.XStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;

public class XmlHandler {
    
    public static MusicBand DeserializeXMLXStream(String dataPath) throws IOException {
        XStream xStream = new XStream();
        xStream.allowTypes(new Class[] {MusicBand.class});
        String content = Files.readString(Path.of(dataPath));
        xStream.alias("MusicBand",MusicBand.class);
        return (MusicBand) xStream.fromXML(content);
    }

    public static String SerializeXMLXStream(Object object) throws ClassNotFoundException {
        Class<?> musicBand = Class.forName("org.example.MusicBands.MusicBand");
        XStream xStream = new XStream();
        xStream.alias("Collection", Set.class);
        xStream.alias("MusicBand", musicBand);
        return xStream.toXML(object);
    }



}
