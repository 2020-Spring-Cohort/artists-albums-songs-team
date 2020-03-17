package org.wcci.apimastery;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.wcci.apimastery.Storage.AlbumRepository;
import org.wcci.apimastery.Storage.ArtistRepository;
import org.wcci.apimastery.Storage.SongRepository;
import org.wcci.apimastery.models.Album;
import org.wcci.apimastery.models.Artist;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class JPAWiringTest {
    @Autowired
    private ArtistRepository artistRepository;
    @Autowired
    private AlbumRepository albumRepository;
    @Autowired
    private SongRepository songRepository;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void albumsShouldHaveAnArtist(){
        Artist testArtist = new Artist("The Testers");
        artistRepository.save(testArtist);

        Album testAlbum = new Album("Best of the Testers", testArtist);
        albumRepository.save(testAlbum);
        Album testAlbum2 = new Album("Testers' Greatest Hits", testArtist);
        albumRepository.save(testAlbum2);

        entityManager.flush();
        entityManager.clear();

        Artist retrievedArtist = artistRepository.findById(testArtist.getId()).get();
        Album retrievedAlbum1 = albumRepository.findById(testAlbum.getId()).get();
        Album retrievedAlbum2 = albumRepository.findById(testAlbum2.getId()).get();
        assertThat(retrievedArtist.getAlbums()).contains(retrievedAlbum1, retrievedAlbum2);
    }
}
