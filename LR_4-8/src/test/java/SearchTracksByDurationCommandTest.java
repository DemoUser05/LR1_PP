/*import model.Track;
import model.TrackManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.SearchTracksByDurationCommand;

import java.util.Scanner;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SearchTracksByDurationCommandTest {

    private TrackManager trackManager;
    private Scanner scanner;
    private SearchTracksByDurationCommand searchTracksByDurationCommand;

    @BeforeEach
    public void setUp() {
        trackManager = new TrackManager();
        // Симуляція введення даних: трек з назвою "Test Track", тривалістю 5.5 хвилин і стилем "Pop"
        scanner = new Scanner("Test Track\n5.5\nPop\n");
    }


    @Test
    void testExecute() {
        searchTracksByDurationCommand.execute();
        List<Track> result = trackManager.searchByDuration(3.0, 6.0);
        assertEquals(1, result.size());
        assertEquals("Track 2", result.get(0).getName());
    }
}*/
