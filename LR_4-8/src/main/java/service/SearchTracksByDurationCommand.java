package service;

import model.TrackManager;
import model.Track;

import java.util.List;
import java.util.Scanner;

public class SearchTracksByDurationCommand implements Command {
    private TrackManager trackManager;
    private Scanner scanner;

    public SearchTracksByDurationCommand(TrackManager trackManager, Scanner scanner) {
        this.trackManager = trackManager;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.print("Enter minimum track duration (in minutes): ");
        double minDuration = scanner.nextDouble();
        System.out.print("Enter maximum track duration (in minutes): ");
        double maxDuration = scanner.nextDouble();
        List<Track> tracks = trackManager.searchByDuration(minDuration, maxDuration);
        if (tracks.isEmpty()) {
            System.out.println("No tracks found within the given duration range.");
        } else {
            System.out.println("Tracks found:");
            trackManager.displayTracks(tracks);
        }
    }
}
