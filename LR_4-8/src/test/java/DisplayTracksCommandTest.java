/*import static org.junit.jupiter.api.Assertions.*;
import model.Track;
import model.TrackManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.DisplayTracksCommand;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class DisplayTracksCommandTest {

    private DisplayTracksCommand displayTracksCommand;
    private TrackManager trackManager;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        trackManager = new TrackManager();
        trackManager.addTrack(new Track("Track 1", 3.5, "Rock"));
        trackManager.addTrack(new Track("Track 2", 4.0, "Pop"));
        displayTracksCommand = new DisplayTracksCommand(trackManager);

        // Перехоплення виводу на консоль
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void testExecute() {
        displayTracksCommand.execute();
        String output = outputStream.toString();
        assertTrue(output.contains("Track 1"));
        assertTrue(output.contains("Track 2"));
    }
}*/
