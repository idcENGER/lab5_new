package org.example.Utility;

import com.thoughtworks.xstream.io.StreamException;
import org.example.Menegers.CollectionManager;
import org.example.MusicBands.MusicBand;

import com.thoughtworks.xstream.XStream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class XmlHandler {
    
    public static MusicBand DeserializeMusicBandXMLXStream(String dataPath) throws IOException {
        XStream xStream = new XStream();
        xStream.allowTypes(new Class[] {MusicBand.class});
        String content = Files.readString(Path.of(dataPath));
        xStream.alias("MusicBand",MusicBand.class);
        return (MusicBand) xStream.fromXML(content);
    }

    public static HashSet<MusicBand> DeserializeCollectionXMLXStream(String dataPath) throws IOException {
        XStream xStream = new XStream();
        xStream.allowTypes(new Class[] {CollectionManager.class,MusicBand.class});
        String content = Files.readString(Path.of(dataPath));
        xStream.alias("MusicBand",MusicBand.class);
        xStream.alias("Collection",HashSet.class);
        try {
            //Cannot cast wrong files
            //noinspection unchecked
            return (HashSet<MusicBand>) xStream.fromXML(content);
        }catch (StreamException exception) {
            if (!content.isBlank()){System.out.println("Cant cast file data to HashSet<MusicBand> or file is empty");}
            return null;
        }
    }

    public static String SerializeXMLXStream(Object object) throws ClassNotFoundException {
        Class<?> musicBand = Class.forName("org.example.MusicBands.MusicBand");
        XStream xStream = new XStream();
        xStream.alias("Collection", Set.class);
        xStream.alias("MusicBand", musicBand);
        return xStream.toXML(object);
    }

    public static String SpaceRemover(String message){
        while (message.startsWith(" ") || message.startsWith("\t")){
            if (message.startsWith(" ")) {message = message.replaceFirst(" ","");}
            if (message.startsWith("\t")) {message = message.replaceFirst("\t","");}
        }
        return message;
    }

}
