package org.wcci.apimastery.Controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.wcci.apimastery.Storage.AlbumStorage;
import org.wcci.apimastery.Storage.ArtistStorage;
import org.wcci.apimastery.Storage.SongStorage;
import org.wcci.apimastery.models.Album;
import org.wcci.apimastery.models.Artist;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class AlbumControllerTest {
    private MockMvc mockMvc;
    private AlbumController underTest;
    private AlbumStorage mockStorage;
    private SongStorage songStorage;

    @BeforeEach
    public void setUp(){
        mockStorage = mock(AlbumStorage.class);
        songStorage = mock(SongStorage.class);
        underTest = new AlbumController(mockStorage, songStorage);
        mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
    }

    @Test
    public void shouldRetrieveAlbums() throws Exception {
        Artist testArtist = new Artist("testBand");
        Album testAlbum = new Album("testAlbum", testArtist);
        when(mockStorage.findByAlbumTitle("testAlbum")).thenReturn(java.util.Optional.of(testAlbum));
        mockMvc.perform(MockMvcRequestBuilders.get("/albums/testAlbum"))
        .andExpect(status().isOk());
    }
}