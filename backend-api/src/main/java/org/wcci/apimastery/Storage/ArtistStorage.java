package org.wcci.apimastery.Storage;


import org.wcci.apimastery.models.Artist;

import java.util.Collection;
import java.util.Optional;

public interface ArtistStorage {
    Collection<Artist> findAllArtists();
    void store(Artist artists);
    Optional<Artist> findArtistById(Long id);
}
