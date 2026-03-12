package org.example.Menegers;


import java.util.HashSet;
import java.io.File;

public class CollectionManager {
    private final HashSet<MusicBand> collections = new HashSet<>();
    public void add(MusicBand musicBand){
        collections.add(musicBand);
    }
    public void clear(){
        collections.clear();
    }

}

class MusicBand{
    File xmlFile = new File("data2.xml");

}