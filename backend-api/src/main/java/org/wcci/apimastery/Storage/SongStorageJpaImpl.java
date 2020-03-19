package org.wcci.apimastery.Storage;

import org.springframework.stereotype.Service;
import org.wcci.apimastery.models.Album;
import org.wcci.apimastery.models.Artist;
import org.wcci.apimastery.models.Song;

import java.util.Optional;

@Service
public class SongStorageJpaImpl implements SongStorage {
    
    private SongRepository repository;
    
    public SongStorageJpaImpl(SongRepository repository) {
        this.repository = repository;
    }
    
    @Override
    public Optional<Song> findSongById(Long id) {
        return repository.findById(id);
    }
    
    @Override
    public Optional<Song> findSongByTitle(String title) {
        return repository.findByTitle(title);
    }
    
    @Override
    public Iterable<Song> findAllByArtist(Artist artist) {
        return repository.findSongsByArtist(artist);
    }
    
    @Override
    public Iterable<Song> findAllByArtistName(String name) {
        return repository.findSongsByArtistName(name);
    }
    
    @Override
    public Iterable<Song> findAllByArtistLabel(String label) {
        return repository.findSongsByArtistLabel(label);
    }
    
    @Override
    public Iterable<Song> findAllByAlbum(Album album) {
        return repository.findSongsByAlbum(album);
    }
    
    @Override
    public Iterable<Song> findAllyByAlbumTitle(String title) {
        return repository.findSongsByAlbumTitle(title);
    }
    
    @Override
    public Iterable<Song> findAllSongs() {
        return repository.findAll();
    }
    
    @Override
    public void remove(Song song) {
        repository.delete(song);
    }
    
    @Override
    public Song save(Song song) {
        return repository.save(song);
    }
}
