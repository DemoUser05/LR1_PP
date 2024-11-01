package service;

import model.Track;

import java.util.List;
import java.util.Scanner;

public class LoadCompilationCommand implements Command {
    private List<Track> tracks;
    private Scanner scanner; // Scanner for user input
    private FileHandler fileHandler; // FileHandler for file operations

    public LoadCompilationCommand(List<Track> tracks, Scanner scanner) {
        this.tracks = tracks;
        this.scanner = scanner; // Initialize scanner
        this.fileHandler = new FileHandler(); // Default file handler
    }

    // Setter for FileHandler to allow mocking
    public void setFileHandler(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
    }

    @Override
    public void execute() {
        System.out.print("Enter the file path to load the compilation: ");
        String filePath = scanner.nextLine(); // Get path from user
        fileHandler.loadFromFile(tracks, filePath);
        System.out.println("Tracks loaded from " + filePath + " successfully.");

        // Print loaded tracks
        System.out.println("Loaded Tracks:");
        if (tracks.isEmpty()) {
            System.out.println("No tracks available.");
        } else {
            for (Track track : tracks) {
                System.out.println(track); // Call toString for each track
            }
        }
    }
}
