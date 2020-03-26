package org.wcci.apimastery.Storage;

import org.springframework.stereotype.Service;
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
    public Iterable<Song> findAllSongs() {
        return repository.findAll();
    }
    
    @Override
    public void remove(Song song) {
        repository.delete(song);
    }
    
    @Override
    public Song store(Song song) {
        return repository.save(song);
    }
}
