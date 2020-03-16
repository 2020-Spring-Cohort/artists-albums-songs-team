package org.wcci.apimastery;

import org.springframework.stereotype.Service;
import org.wcci.apimastery.Storage.ArtistRepository;
import org.wcci.apimastery.Storage.ArtistStorage;
import org.wcci.apimastery.models.Artist;

import java.util.Collection;

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
    public Artist findArtistById(Long id) {
        return artistRepo.findById(id).get();
    }
}
