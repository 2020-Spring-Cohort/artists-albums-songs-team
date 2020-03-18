package org.wcci.apimastery.Controllers;

import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.Storage.AlbumStorage;
import org.wcci.apimastery.Storage.ArtistStorage;
import org.wcci.apimastery.Storage.SongStorage;
import org.wcci.apimastery.models.Album;
import org.wcci.apimastery.models.Artist;
import org.wcci.apimastery.models.Song;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/songs")
public class SongController {
    
    private SongStorage songStorage;
    private ArtistStorage artistStorage;
    private AlbumStorage albumStorage;
    
    public SongController(SongStorage songStorage, ArtistStorage artistStorage, AlbumStorage albumStorage) {
        this.songStorage = songStorage;
        this.artistStorage = artistStorage;
        this.albumStorage = albumStorage;
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
        Optional<Artist> retrievedArtist = artistStorage.findArtistByName(artistName);
    
        return retrievedArtist.map(Artist::getSongs).orElse(null);
    }
    
    @GetMapping("/{albumName}")
    public Collection<Song> showSongsByAlbumName(@PathVariable String albumName) {
        Optional<Album> retrievedAlbum = albumStorage.findByAlbumTitle(albumName);
        
        return retrievedAlbum.map(Album::getSongs).orElse(null);
    }
    
    @DeleteMapping("/{title}")
    public void deleteSongByTitle(@PathVariable String title) {
        Optional<Song> songOptional = songStorage.findSongByTitle(title);
        
        songOptional.ifPresent(song -> songStorage.remove(song));
    }
    
    @PutMapping("/{id}")
    public Song putSong(@PathVariable Long id, @RequestBody Song song) {
    
        Optional<Song> songOptional = songStorage.findSongById(id);
    
        if (songOptional.isPresent()) {
            return songStorage.save(song);
        }
        return null;
    }
    
    @PatchMapping("/{id}/comment")
    public Song patchSong(@PathVariable Long id, @RequestBody String comment) {
        
        Optional<Song> songOptional = songStorage.findSongById(id);
        
        if (songOptional.isPresent()) {
            Song oldSong = songOptional.get();
            
            oldSong.getComments().add(comment);
            
            return songStorage.save(oldSong);
        }
        return null;
    }
    
    @PatchMapping("/{id}/rating")
    public Song patchSong(@PathVariable Long id, @RequestBody int rating) {
        
        Optional<Song> songOptional = songStorage.findSongById(id);
        
        if (songOptional.isPresent()) {
            Song oldSong = songOptional.get();
            
            oldSong.getRatings().add(rating);
            
            return songStorage.save(oldSong);
        }
        return null;
    }
}
