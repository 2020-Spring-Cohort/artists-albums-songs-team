package org.wcci.apimastery.Storage;
import org.wcci.apimastery.models.Album;
import java.util.Collection;


public interface AlbumStorage{
    Collection<Album> findAllAlbums();
    Album findAlbumById(Long id);
    void store(Album albumToStore);
}
