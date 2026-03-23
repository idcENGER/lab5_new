package org.example.Menegers;

import org.example.MusicBands.MusicBand;
import org.example.Utility.XmlHandler;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashSet;

public class CollectionManager {
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

    public Integer getSize(){
        return collections.size();
    }

    public Object recoverCollection(String path) throws IOException {
        return  XmlHandler.DeserializeXMLXStream(path);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{size:" + collections.size() + "}";
    }

}

