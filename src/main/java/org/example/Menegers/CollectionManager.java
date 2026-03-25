package org.example.Menegers;

import org.example.MusicBands.MusicBand;
import org.example.Utility.XmlHandler;

import java.io.IOException;
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

    public void recoverCollection(String path) throws IOException,NullPointerException {
        HashSet<MusicBand> data = XmlHandler.DeserializeCollectionXMLXStream(path);
        if (data!=null) {collections.addAll(data);}
    }

    public MusicBand getMusicBandByID(int id){
        try {
            for (MusicBand musicBand : collections) {
                if (musicBand.getId() == id) {
                    return musicBand;
                }
            }
        }catch (NullPointerException ex){
            System.out.println("Collection is empty");
        }
        System.out.println("Музыкальной группы с таким id нет");
        return null;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{size:" + collections.size() + "}";
    }

}

