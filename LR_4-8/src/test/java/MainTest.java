import model.TrackManager;
import main.Main;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.*;

import java.util.Scanner;

import static org.mockito.Mockito.*;

class MainTest {
    private CommandManager commandManager;
    private TrackManager trackManager;
    private Command addTrack;
    private Command removeTrack;
    private Command sortByStyle;
    private Command searchByDuration;
    private Command displayTracks;
    private Command saveCompilation;
    private Command loadCompilation;
    private Scanner scanner;

    @BeforeEach
    void setUp() {
        commandManager = mock(CommandManager.class);
        trackManager = new TrackManager();
        scanner = new Scanner(System.in);

        addTrack = mock(AddTrackCommand.class);
        removeTrack = mock(RemoveTrackCommand.class);
        sortByStyle = mock(SortTracksByStyleCommand.class);
        searchByDuration = mock(SearchTracksByDurationCommand.class);
        displayTracks = mock(DisplayTracksCommand.class);
        saveCompilation = mock(SaveCompilationCommand.class);
        loadCompilation = mock(LoadCompilationCommand.class);
    }

    @Test
    void testProcessUserChoice_DisplayTracks() {
        Main main = new Main();
        main.processUserChoice(1, commandManager, addTrack, removeTrack, sortByStyle,
                searchByDuration, displayTracks, saveCompilation, loadCompilation, scanner);

        verify(commandManager).runCommand(displayTracks);
    }

    @Test
    void testProcessUserChoice_AddTrack() {
        Main main = new Main();
        main.processUserChoice(2, commandManager, addTrack, removeTrack, sortByStyle,
                searchByDuration, displayTracks, saveCompilation, loadCompilation, scanner);

        verify(commandManager).runCommand(addTrack);
    }

    @Test
    void testProcessUserChoice_RemoveTrack() {
        Main main = new Main();
        main.processUserChoice(3, commandManager, addTrack, removeTrack, sortByStyle,
                searchByDuration, displayTracks, saveCompilation, loadCompilation, scanner);

        verify(commandManager).runCommand(removeTrack);
    }

    @Test
    void testProcessUserChoice_SortByStyle() {
        Main main = new Main();
        main.processUserChoice(4, commandManager, addTrack, removeTrack, sortByStyle,
                searchByDuration, displayTracks, saveCompilation, loadCompilation, scanner);

        verify(commandManager).runCommand(sortByStyle);
    }

    @Test
    void testProcessUserChoice_SearchByDuration() {
        Main main = new Main();
        main.processUserChoice(5, commandManager, addTrack, removeTrack, sortByStyle,
                searchByDuration, displayTracks, saveCompilation, loadCompilation, scanner);

        verify(commandManager).runCommand(searchByDuration);
    }

    @Test
    void testProcessUserChoice_SaveCompilation() {
        Main main = new Main();
        main.processUserChoice(6, commandManager, addTrack, removeTrack, sortByStyle,
                searchByDuration, displayTracks, saveCompilation, loadCompilation, scanner);

        verify(commandManager).runCommand(saveCompilation);
    }

    @Test
    void testProcessUserChoice_LoadCompilation() {
        Main main = new Main();
        main.processUserChoice(7, commandManager, addTrack, removeTrack, sortByStyle,
                searchByDuration, displayTracks, saveCompilation, loadCompilation, scanner);

        verify(commandManager).runCommand(loadCompilation);
    }
}
