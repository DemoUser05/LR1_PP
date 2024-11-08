package service;

import model.Track;
import model.TrackManager;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddTrackCommand implements Command {
    private static final Logger logger = LoggerConfig.getLogger();
    private TrackManager trackManager;
    private Scanner scanner;

    public AddTrackCommand(TrackManager trackManager, Scanner scanner) {
        this.trackManager = trackManager;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        try {
            System.out.print("Enter track name: ");
            String name = scanner.nextLine();
            System.out.print("Enter track duration (in minutes): ");
            double duration = scanner.nextDouble();
            scanner.nextLine();  // Clear buffer
            System.out.print("Enter track style: ");
            String style = scanner.nextLine();

            trackManager.addTrack(new Track(name, duration, style));
            System.out.println("Track added successfully.");
            logger.log(Level.INFO, "Track added: {0}", name);

        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error adding track", e);
        }
    }
}
