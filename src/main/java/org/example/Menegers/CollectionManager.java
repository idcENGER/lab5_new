package org.example.Menegers;

import org.example.MusicBands.MusicBand;

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

    @Override
    public String toString() {
        return super.toString();
    }

}

