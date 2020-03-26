package org.wcci.apimastery;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wcci.apimastery.Storage.AlbumStorage;
import org.wcci.apimastery.Storage.ArtistStorage;
import org.wcci.apimastery.Storage.SongStorage;
import org.wcci.apimastery.models.Album;
import org.wcci.apimastery.models.Artist;
import org.wcci.apimastery.models.Song;

@Component
public class Populator implements CommandLineRunner {

    ArtistStorage artistStorage;
    AlbumStorage albumStorage;
    SongStorage songStorage;

    public Populator(ArtistStorage artistStorage, AlbumStorage albumStorage, SongStorage songStorage) {
        this.artistStorage = artistStorage;
        this.albumStorage = albumStorage;
        this.songStorage = songStorage;
    }

    @Override
    public void run(String... args) {
        Artist meshuggah = new Artist("Meshuggah", 1987, "https://www.nuclearblast.de/en/data/imagedata/band-header/meshuggah-bandheader.jpg?x=1110", "Nuclear Blast");
        artistStorage.store(meshuggah);
    
        Artist polyphia = new Artist("Polyphia", 2010, "https://lh3.googleusercontent.com/proxy/Tcyb-GEAdOdDCE_7ymXTOrORTy3UXZTCrbPtdTzP9eyAlDIxiKrxAuzU3jSQ5fLvTfFXp5UcilyaPaPcvesfcN02vELHSRF0NaC-3xuJciny7xOdjSzMWpn_duDUGi5JVnIjUWD6HatQCgA3rfdwU2ZNfWzDXvbdNWpReyRa", "Headphone Music");
        artistStorage.store(polyphia);
    
        Artist vomitTheSoul = new Artist("Vomit The Soul", 2000, "https://www.metal-archives.com/images/1/3/6/8/13688_photo.jpg?4959", "Unique Leader Records");
        artistStorage.store(vomitTheSoul);
    
        Artist morbidAngel = new Artist("Morbid Angel", 1983, "https://metalinjection.net/wp-content/uploads/2019/09/11227053_10206596943498711_6732990489779844999_o.jpg", "Earache Records");
        artistStorage.store(morbidAngel);
    
        Album obZen = new Album("obZen", meshuggah, "Nuclear Blast", null);
        albumStorage.store(obZen);
    
        Album newLevelsNewDevils = new Album("New Levels New Devils", polyphia, "Headphone Music", null);
        albumStorage.store(newLevelsNewDevils);
    
        Album apostlesOfInexpression = new Album("Apostles of Inexpression", vomitTheSoul, "Unique Leader Records", null);
        albumStorage.store(apostlesOfInexpression);
    
        Album covenant = new Album("Covenant", morbidAngel, "Earache Records", null);
        albumStorage.store(covenant);
    
        Song bleed = new Song("Bleed", meshuggah, obZen);
        songStorage.store(bleed);
    
        Song goat = new Song("G.O.A.T.", polyphia, newLevelsNewDevils);
        songStorage.store(goat);
    
        Song selfPerceptionVeil = new Song("Self Perception Veil", vomitTheSoul, apostlesOfInexpression);
        songStorage.store(selfPerceptionVeil);
    
        Song godOfEmptiness = new Song("God of Emptiness", morbidAngel, covenant);
        songStorage.store(godOfEmptiness);
    
        obZen.addSong(bleed);
    
        newLevelsNewDevils.addSong(goat);
    
        apostlesOfInexpression.addSong(selfPerceptionVeil);
    
        covenant.addSong(godOfEmptiness);
    
        albumStorage.store(obZen);
        albumStorage.store(newLevelsNewDevils);
        albumStorage.store(apostlesOfInexpression);
        albumStorage.store(covenant);
    }
}
