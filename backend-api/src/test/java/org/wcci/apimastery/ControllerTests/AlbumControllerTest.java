package org.wcci.apimastery.ControllerTests;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.wcci.apimastery.Controllers.AlbumController;
import org.wcci.apimastery.Storage.AlbumRepository;

import static org.mockito.Mockito.mock;

public class AlbumControllerTest {

    private MockMvc mockMvc;
    private AlbumController testAlbumCont;
    private AlbumRepository albumRepository;
    private Model mockModel;

    @BeforeEach
    public void setUp(){
        mockModel = mock(Model.class);
        albumRepository = mock(AlbumRepository.class);
        testAlbumCont = new AlbumController(albumRepository);
        mockMvc = MockMvcBuilders.standaloneSetup(testAlbumCont).build();
    }

//    @Test
//    public void shouldReturnAllAlbums(){
//        Album testAlbum = new Album();
//
//    }
}
