/*import static org.junit.jupiter.api.Assertions.*;
import model.Track;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.FileHandler;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

class FileHandlerTest {

    private FileHandler fileHandler;
    private List<Track> tracks;

    @BeforeEach
    void setUp() {
        fileHandler = new FileHandler();
        tracks = new ArrayList<>();
        tracks.add(new Track("Track 1", 3.0, "Rock"));
        tracks.add(new Track("Track 2", 4.0, "Pop"));
    }

    @Test
    void testSaveToFile() {
        fileHandler.saveToFile(tracks, "test_tracks.txt");
        File file = new File("test_tracks.txt");
        assertTrue(file.exists());
    }

    @Test
    void testLoadFromFile() {
        fileHandler.saveToFile(tracks, "test_tracks.txt");
        List<Track> loadedTracks = new ArrayList<>();
        fileHandler.loadFromFile(loadedTracks, "test_tracks.txt");
        assertEquals(2, loadedTracks.size());
        assertEquals("Track 1", loadedTracks.get(0).getName());
    }
}*/
