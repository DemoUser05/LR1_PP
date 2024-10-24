/*import model.Track;
import model.TrackManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.SortTracksByStyleCommand;

import static org.junit.jupiter.api.Assertions.*;

class SortTracksByStyleCommandTest {

    private TrackManager trackManager;
    private SortTracksByStyleCommand sortTracksByStyleCommand;

    @BeforeEach
    void setUp() {
        trackManager = new TrackManager();
        trackManager.addTrack(new Track("Track 1", 4.0, "Rock"));
        trackManager.addTrack(new Track("Track 2", 5.0, "Jazz"));
        sortTracksByStyleCommand = new SortTracksByStyleCommand(trackManager);
    }

    @Test
    void testExecute() {
        sortTracksByStyleCommand.execute();
        assertEquals("Jazz", trackManager.getTracks().get(0).getStyle());
        assertEquals("Rock", trackManager.getTracks().get(1).getStyle());
    }
}*/
