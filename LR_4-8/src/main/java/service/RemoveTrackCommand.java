package service;

import model.TrackManager;

import java.util.Scanner;

public class RemoveTrackCommand implements Command {
    private TrackManager trackManager;
    private Scanner scanner;

    public RemoveTrackCommand(TrackManager trackManager, Scanner scanner) {
        this.trackManager = trackManager;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.print("Enter the name of the track to remove: ");
        String trackName = scanner.nextLine();
        if (trackManager.removeTrackByName(trackName)) {
            System.out.println("Track removed successfully.");
        } else {
            System.out.println("Track not found.");
        }
    }
}
