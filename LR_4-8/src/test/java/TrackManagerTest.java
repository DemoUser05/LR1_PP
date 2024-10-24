/*import static org.junit.jupiter.api.Assertions.*;
import model.Track;
import model.TrackManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class TrackManagerTest {

    private TrackManager trackManager;

    @BeforeEach
    void setUp() {
        trackManager = new TrackManager();
    }

    @Test
    void testAddTrack() {
        Track track = new Track("New Track", 4.0, "Pop");
        trackManager.addTrack(track);
        assertEquals(1, trackManager.getTracks().size()); //кількість треків після додавання дорівнює 1.
        assertEquals("New Track", trackManager.getTracks().get(0).getName()); //назва першого треку відповідає доданому треку
    }

    @Test
    void testRemoveTrackByName() {
        Track track = new Track("Old Track", 4.0, "Rock");
        trackManager.addTrack(track);
        assertTrue(trackManager.removeTrackByName("Old Track")); // метод повертає true(трек був успішно видалений)
        assertEquals(0, trackManager.getTracks().size()); //кількість треків після видалення дорівнює 0
    }

    @Test
    void testSearchByDuration() {
        trackManager.addTrack(new Track("Track 1", 2.0, "Rock"));
        trackManager.addTrack(new Track("Track 2", 5.0, "Pop"));
        List<Track> result = trackManager.searchByDuration(3.0, 6.0);
        assertEquals(1, result.size());
        assertEquals("Track 2", result.get(0).getName());
    }

    @Test
    void testSortTracksByStyle() {
        trackManager.addTrack(new Track("Track 1", 3.0, "Rock"));
        trackManager.addTrack(new Track("Track 2", 4.0, "Jazz"));
        trackManager.sortTracksByStyle();
        assertEquals("Jazz", trackManager.getTracks().get(0).getStyle());
        assertEquals("Rock", trackManager.getTracks().get(1).getStyle());
    }
}*/
