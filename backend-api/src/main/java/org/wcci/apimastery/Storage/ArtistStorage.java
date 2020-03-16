package org.wcci.apimastery.Storage;


import org.wcci.apimastery.models.Artist;

import java.util.Collection;

public interface ArtistStorage {
    Collection<Artist> findAllArtists();
    void store(Artist artists);
    Artist findArtistById(Long id);
}
