package org.wcci.apimastery.Storage;

import org.springframework.data.repository.CrudRepository;
import org.wcci.apimastery.models.Album;
import org.wcci.apimastery.models.Artist;
import org.wcci.apimastery.models.Song;

import java.util.Optional;

public interface SongRepository extends CrudRepository<Song, Long> {
    
    Optional<Song> findByTitle(String title);
    
    Optional<Song> findSongsByArtist(Artist artist);
    
    Optional<Song> findSongsByArtistName(String name);
    
    Optional<Song> findSongsByArtistLabel(String label);
    
    Optional<Song> findSongsByAlbum(Album album);
    
    Optional<Song> findSongsByAlbumTitle(String title);
    
    Optional<Song> findSongsByArtistNumberOfBlackShirts(String blackShirts);
    
}
