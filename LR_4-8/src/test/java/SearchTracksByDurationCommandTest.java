import model.Track;
import model.TrackManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.SearchTracksByDurationCommand;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Locale;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SearchTracksByDurationCommandTest {
    private TrackManager trackManager;

    @BeforeEach
    void setUp() {
        trackManager = new TrackManager();
        // Додаємо тестові треки до TrackManager
        trackManager.addTrack(new Track("Track1", 2.5, "Rock"));
        trackManager.addTrack(new Track("Track2", 4.0, "Pop"));
        trackManager.addTrack(new Track("Track3", 5.5, "Jazz"));
        trackManager.addTrack(new Track("Track4", 7.0, "Classical"));
    }

    @Test
    void testExecute() {
        // Симулюємо введення діапазону тривалостей: 3.0 - 6.0 хвилин
        String simulatedInput = "3.0\n6.0\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner scanner = new Scanner(inputStream);
        scanner.useLocale(Locale.US);

        SearchTracksByDurationCommand command = new SearchTracksByDurationCommand(trackManager, scanner);
        command.execute();

        // Перевіряємо, що команда знайшла правильні треки
        var tracks = trackManager.searchByDuration(3.0, 6.0);
        assertEquals(2, tracks.size(), "Треків має бути два у вказаному діапазоні.");
        assertTrue(tracks.stream().anyMatch(track -> track.getName().equals("Track2")));
        assertTrue(tracks.stream().anyMatch(track -> track.getName().equals("Track3")));
    }
}
