import model.Track;
import model.TrackManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.AddTrackCommand;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddTrackCommandTest {

    private TrackManager trackManager;

    @BeforeEach
    void setUp() {
        trackManager = new TrackManager();
    }

    @Test
    void testExecute() {
        // Імітуємо введення користувача
        String simulatedInput = "Test Track\n4.5\nRock\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner scanner = new Scanner(inputStream);
        scanner.useLocale(Locale.US);  // Задаємо локаль

        AddTrackCommand addTrackCommand = new AddTrackCommand(trackManager, scanner);
        addTrackCommand.execute();

        // Перевірка, чи трек був доданий до TrackManager
        List<Track> tracks = trackManager.getTracks();
        assertEquals(1, tracks.size());
        assertEquals("Test Track", tracks.get(0).getName());
        assertEquals(4.5, tracks.get(0).getDuration());
        assertEquals("Rock", tracks.get(0).getStyle());
    }
}
