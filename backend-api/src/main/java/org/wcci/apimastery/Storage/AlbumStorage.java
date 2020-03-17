package org.wcci.apimastery.Storage;

import org.wcci.apimastery.models.Album;

import java.util.Collection;
import java.util.Optional;


public interface AlbumStorage{
    Collection<Album> findAllAlbums();
    Optional<Album> findAlbumById(Long id);
    Optional<Album> findByAlbumTitle(String title);
    Optional<Album> findByAlbumLabel(String label);
    Optional<Album> findAlbumByArtistName(String artistName);
    void store(Album albumToStore);
}
