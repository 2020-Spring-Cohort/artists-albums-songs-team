package org.wcci.apimastery.Storage;

import org.springframework.data.repository.CrudRepository;
import org.wcci.apimastery.models.Album;
import org.wcci.apimastery.models.Artist;
import org.wcci.apimastery.models.Song;

import java.util.Optional;

public interface SongRepository extends CrudRepository<Song, Long> {
    
    Optional<Song> findByTitle(String title);
    
    Iterable<Song> findSongsByArtist(Artist artist);
    
    Iterable<Song> findSongsByArtistName(String name);
    
    Iterable<Song> findSongsByArtistLabel(String label);
    
    Iterable<Song> findSongsByAlbum(Album album);
    
    Iterable<Song> findSongsByAlbumTitle(String title);
    
}
