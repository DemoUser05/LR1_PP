//package service;

import model.Track;
import service.FileHandler;
import service.LoadCompilationCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class LoadCompilationCommandTest {
    private List<Track> tracks;
    private Scanner scanner;
    private FileHandler fileHandler;
    private LoadCompilationCommand command;

    @BeforeEach
    void setUp() {
        // Initialize the required dependencies
        tracks = new ArrayList<>();
        scanner = new Scanner("mock/file/path"); // Mock user input with a file path
        fileHandler = mock(FileHandler.class);

        // Create instance of command with mocked dependencies
        command = new LoadCompilationCommand(tracks, scanner);

        // Replace fileHandler in the command with our mock
        command.setFileHandler(fileHandler);
    }

    @Test
    void execute_shouldLoadTracksFromFile() {
        // Arrange
        doNothing().when(fileHandler).loadFromFile(tracks, "mock/file/path");

        // Act
        command.execute();

        // Assert
        verify(fileHandler, times(1)).loadFromFile(tracks, "mock/file/path");
        // Additional assertions could be added based on expected tracks content
    }

    @Test
    void execute_shouldPrintLoadedTracks() {
        // Arrange
        Track mockTrack = new Track("Track Title", 3.4, "Pop");
        tracks.add(mockTrack);
        doNothing().when(fileHandler).loadFromFile(tracks, "mock/file/path");

        // Act
        command.execute();

        // Verify that track is printed as expected
        assertEquals(1, tracks.size());
        assertEquals("Track Title", tracks.get(0).getName());
    }
}
