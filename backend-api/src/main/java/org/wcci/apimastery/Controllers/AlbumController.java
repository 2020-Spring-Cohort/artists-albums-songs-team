package org.wcci.apimastery.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wcci.apimastery.Storage.AlbumRepository;
import org.wcci.apimastery.models.Album;

import java.util.Collection;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    private AlbumRepository albumRepository;

    public AlbumController(AlbumRepository albumRepository){
        this.albumRepository = albumRepository;
    }

    @RequestMapping("/albums")
    public Collection<Album> retrieveAlbums(){
        return (Collection<Album>) albumRepository.findAll();
    }
}
