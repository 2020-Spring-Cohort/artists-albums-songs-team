package org.wcci.apimastery.Controllers;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.wcci.apimastery.Storage.ArtistStorage;
import org.wcci.apimastery.models.Artist;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ArtistControllerTest {
    private MockMvc mockMvc;
    private ArtistController underTest;
    private ArtistStorage mockStorage;

    @BeforeEach
    public void setUp(){
        mockStorage = mock(ArtistStorage.class);
        underTest = new ArtistController(mockStorage);
        mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
    }

    @Test
    public void shouldPopulateArtist() throws Exception {
        Artist testArtist = new Artist("Test Band");
        when(mockStorage.findArtistByName("Test Band")).thenReturn(java.util.Optional.of(testArtist));
        mockMvc.perform(MockMvcRequestBuilders.get("/artists/Test Band"))
                .andExpect(status().isOk());
    }
}