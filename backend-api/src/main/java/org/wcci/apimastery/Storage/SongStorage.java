package org.wcci.apimastery.Storage;

import org.wcci.apimastery.models.Song;

import java.util.Optional;

public interface SongStorage {
    
    Optional<Song> findSongById(Long id);
    
    Optional<Song> findSongByTitle(String title);
    
    Iterable<Song> findAllSongs();
    
    void remove(Song song);
    
    Song store(Song song);
    
}
