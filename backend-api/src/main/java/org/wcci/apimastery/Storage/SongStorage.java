package org.wcci.apimastery.Storage;

import org.wcci.apimastery.models.Album;
import org.wcci.apimastery.models.Artist;
import org.wcci.apimastery.models.Song;

import java.util.Optional;

public interface SongStorage {
    
    Optional<Song> findSongByTitle(String title);
    
    Iterable<Song> findAllByArtist(Artist artist);
    
    Iterable<Song> findAllByArtistName(String name);
    
    Iterable<Song> findAllByArtistLabel(String label);
    
    Iterable<Song> findAllByAlbum(Album album);
    
    Iterable<Song> findAllyByAlbumTitle(String title);
    
    Iterable<Song> findAllSongs();
    
}
