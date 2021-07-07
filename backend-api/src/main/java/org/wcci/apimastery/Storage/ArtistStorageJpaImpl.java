package org.wcci.apimastery.Storage;

import org.springframework.stereotype.Service;
import org.wcci.apimastery.models.Artist;

import java.util.Collection;
import java.util.Optional;

@Service
public class ArtistStorageJpaImpl implements ArtistStorage {

    private ArtistRepository artistRepo;

    public ArtistStorageJpaImpl(ArtistRepository artistRepo){
        this.artistRepo = artistRepo;
    }


    @Override
    public Collection<Artist> findAllArtists() {
        return (Collection<Artist>) artistRepo.findAll();
    }
    
    @Override
    public void store(Artist artists) {
        artistRepo.save(artists);
    }
    
    @Override
    public Optional<Artist> findArtistById(Long id) {
        return artistRepo.findById(id);
    }
    
    @Override
    public Optional<Artist> findArtistByName(String name) {
        return artistRepo.findByName(name);
    }
    
    @Override
    public Optional<Artist> findArtistByAge(int age) {
        return artistRepo.findByAge(age);
    }
    
    @Override
    public Optional<Artist> findArtistByLabel(String label) {
        return artistRepo.findByLabel(label);
    }
}
