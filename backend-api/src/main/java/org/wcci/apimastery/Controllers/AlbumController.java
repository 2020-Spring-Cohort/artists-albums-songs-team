package org.wcci.apimastery.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wcci.apimastery.Storage.AlbumStorage;
import org.wcci.apimastery.models.Album;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    private AlbumStorage albumStorage;

    public AlbumController(AlbumStorage albumStorage) {
        this.albumStorage = albumStorage;
    }

    @GetMapping
    public Collection<Album> retrieveAlbums() {
        return albumStorage.findAllAlbums();
    }

    @GetMapping("/{title}")
    public Album showAlbumByTitle(@PathVariable String title){
        Optional<Album> retrievedAlbum = albumStorage.findByAlbumTitle(title);

        return retrievedAlbum.orElse(null);
    }

    @GetMapping("/{albumArtist}")
    public Album showAlbumByArtist(@PathVariable String albumArtist){
        Optional<Album> retrievedAlbum = albumStorage.findAlbumByArtistName(albumArtist);

        return retrievedAlbum.orElse(null);
    }

    @GetMapping("/{albumLabel}")
    public Album showAlbumBySong(@PathVariable String albumLabel){
        Optional<Album> retrievedAlbum = albumStorage.findByAlbumLabel(albumLabel);

        return retrievedAlbum.orElse(null);
    }

    /*
    @GetMapping("{songTitle}")
    public Album showAlbumBySongTitle(@PathVariable String songTitle){
    return songStorage.findSongByTitle(title).get().getAlbum();
    }
     */
}
