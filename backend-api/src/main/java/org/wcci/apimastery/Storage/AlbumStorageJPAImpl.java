package org.wcci.apimastery.Storage;

import java.util.Collection;
import java.util.Optional;

import org.wcci.apimastery.models.Album;
import org.springframework.stereotype.Service;

@Service 
public class AlbumStorageJPAImpl implements AlbumStorage{
    private AlbumRepository albumRepository;

    public AlbumStorageJPAImpl(AlbumRepository albumRepository){
    this.albumRepository = albumRepository;

    }

@Override
public Collection<Album> findAllAlbums(){
    return (Collection<Album>) albumRepository.findAll();
}

@Override
public Optional<Album> findAlbumById(Long id){
    return albumRepository.findById(id);
}

    @Override
    public Optional<Album> findByAlbumTitle(String title) {
        return albumRepository.findByTitle(title);
    }

    @Override
    public Optional<Album> findByAlbumLabel(String label) {
        return albumRepository.findByLabel(label);
    }

    @Override
    public Optional<Album> findAlbumByArtistName(String artistName) {
        return albumRepository.findByArtistName(artistName);
    }

    @Override
public void store(Album albumToStore){
    albumRepository.save(albumToStore);
}

}