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
    public void run(String... args) throws Exception {
        Artist meshuggah = new Artist("Meshuggah", 1987, "this is going to be a link maybe", "Nuclear Blast");
        artistStorage.store(meshuggah);

        Artist polyphia = new Artist("Polyphia", 2010, "imageLink", "Headphone Music");
        artistStorage.store(polyphia);

        Artist vomitTheSoul = new Artist("Vomit The Soul", 2000, "imageLink", "Unique Leader Records");
        artistStorage.store(vomitTheSoul);

        Artist morbidAngel = new Artist("Morbid Angel", 1983, "imageLink", "Earache Records");
        artistStorage.store(morbidAngel);

        Album obZen = new Album("obZen", meshuggah);
        albumStorage.store(obZen);

        Album newLevelsNewDevils = new Album("New Levels New Devils", polyphia);
        albumStorage.store(newLevelsNewDevils);

        Album apostlesOfInexpression = new Album("Apostles of Inexpression", vomitTheSoul);
        albumStorage.store(apostlesOfInexpression);

        Album covenant = new Album("Covenant", morbidAngel);
        albumStorage.store(covenant);

        Song bleed= new Song("Bleed", meshuggah, obZen);
        songStorage.store(bleed);

        Song goat = new Song("G.O.A.T.", polyphia, newLevelsNewDevils);
        songStorage.store(goat);

        Song selfPerceptionVeil = new Song("Self Perception Veil", vomitTheSoul, apostlesOfInexpression);
        songStorage.store(selfPerceptionVeil);

        Song godOfEmptiness = new Song("God of Emptiness", morbidAngel, covenant);
        songStorage.store(godOfEmptiness);
    }
}
