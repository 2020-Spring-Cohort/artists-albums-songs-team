package org.wcci.apimastery.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wcci.apimastery.Storage.ArtistStorage;
import org.wcci.apimastery.Storage.SongStorage;
import org.wcci.apimastery.models.Song;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/songs")
public class SongController {
    
    private SongStorage songStorage;
    private ArtistStorage artistStorage;
    
    public SongController(SongStorage songStorage, ArtistStorage artistStorage) {
        this.songStorage = songStorage;
        this.artistStorage = artistStorage;
    }
    
    @GetMapping
    public Collection<Song> showAllSongs() {
        return (Collection<Song>) songStorage.findAllSongs();
    }
    
    @GetMapping("/{title}")
    public Song showSongByTitle(@PathVariable String title) {
        Optional<Song> retrievedSong = songStorage.findSongByTitle(title);
        
        return retrievedSong.orElse(null);
    }
    
    @GetMapping("/{artistName}")
    public Collection<Song> showSongsByArtistName(@PathVariable String artistName) {
        // TODO: Create method to find artist by name
        return null;
    }
    
    @GetMapping("/{albumName}")
    public Collection<Song> showSongsByAlbumName(@PathVariable String albumName) {
        // TODO: Create method to find album by name
        return null;
    }
}
