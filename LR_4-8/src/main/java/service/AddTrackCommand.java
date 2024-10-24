package service;

import model.TrackManager;
import model.Track;

import java.util.Scanner;

public class AddTrackCommand implements Command {
    private TrackManager trackManager;
    private Scanner scanner;

    public AddTrackCommand(TrackManager trackManager, Scanner scanner) {
        this.trackManager = trackManager;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.print("Enter track name: ");
        String name = scanner.nextLine();
        System.out.print("Enter track duration (in minutes): ");
        double duration = scanner.nextDouble();
        scanner.nextLine();  // Очистка буферу
        System.out.print("Enter track style: ");
        String style = scanner.nextLine();

        trackManager.addTrack(new Track(name, duration, style));
        System.out.println("Track added successfully.");
    }
}

