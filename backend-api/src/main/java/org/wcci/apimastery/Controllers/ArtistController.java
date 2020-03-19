package org.wcci.apimastery.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wcci.apimastery.Storage.ArtistStorage;
import org.wcci.apimastery.models.Artist;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/artists")
public class ArtistController {

    private ArtistStorage artistStorage;

    public ArtistController(ArtistStorage artistStorage){
        this.artistStorage = artistStorage;
    }

    @GetMapping
    public Collection<Artist> showAllArtists(){
        return artistStorage.findAllArtists();
    }

    @GetMapping("/{artistName}")
    public Artist showArtistByName(@PathVariable String artistName){
        Optional<Artist> retrievedArtist = artistStorage.findArtistByName(artistName);

        return retrievedArtist.orElse(null);
    }

    @GetMapping("/label/{artistLabel}")
    public Artist showArtistByLabel(@PathVariable String artistLabel){
        Optional<Artist> retrievedArtist = artistStorage.findArtistByLabel(artistLabel);

        return retrievedArtist.orElse(null);
    }

    //Not adding findArtistByAge because can't see user doing that -Gaelan & Nick
}
