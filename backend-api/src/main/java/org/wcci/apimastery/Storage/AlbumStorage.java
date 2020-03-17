package org.wcci.apimastery.Storage;

import org.wcci.apimastery.models.Album;

import java.util.Collection;
import java.util.Optional;


public interface AlbumStorage{
    Collection<Album> findAllAlbums();
    Optional<Album> findAlbumById(Long id);
    void store(Album albumToStore);
}
