package org.wcci.apimastery.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wcci.apimastery.Storage.AlbumStorage;
import org.wcci.apimastery.models.Album;

import java.util.Collection;

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
}
