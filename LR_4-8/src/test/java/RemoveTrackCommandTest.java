/*import model.Track;
import model.TrackManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.RemoveTrackCommand;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class RemoveTrackCommandTest {

    private TrackManager trackManager;
    private Scanner scanner;
    private RemoveTrackCommand removeTrackCommand;

    @BeforeEach
    void setUp() {
        trackManager = new TrackManager();
        trackManager.addTrack(new Track("Track to remove", 4.0, "Pop"));
        scanner = new Scanner("Track to remove\n"); // Імітуємо введення назви треку для видалення
        removeTrackCommand = new RemoveTrackCommand(trackManager, scanner);
    }

    @Test
    void testExecute() {
        removeTrackCommand.execute();
        assertEquals(0, trackManager.getTracks().size());
    }
}*/
