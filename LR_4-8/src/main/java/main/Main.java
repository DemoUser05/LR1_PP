package main;

import model.Track;
import model.TrackManager;
import service.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Track> tracks = new ArrayList<>();
        TrackManager trackManager = new TrackManager();
        Scanner scanner = new Scanner(System.in);

        Command addTrack = new AddTrackCommand(trackManager, scanner);
        Command removeTrack = new RemoveTrackCommand(trackManager, scanner);
        Command sortByStyle = new SortTracksByStyleCommand(trackManager);
        Command searchByDuration = new SearchTracksByDurationCommand(trackManager, scanner);
        Command displayTracks = new DisplayTracksCommand(trackManager);
        Command saveCompilation = new SaveCompilationCommand(trackManager, scanner); // Додати сканер
        Command loadCompilation = new LoadCompilationCommand(tracks, scanner); // Додати сканер

        CommandManager commandManager = new CommandManager();

        while (true) {
            System.out.println("\n\t\t----- Menu -----");
            System.out.println("1. Display all tracks.");
            System.out.println("2. Add a new track.");
            System.out.println("3. Remove a track.");
            System.out.println("4. Sort tracks by style.");
            System.out.println("5. Search tracks by duration.");
            System.out.println("6. Save compilation to file.");
            System.out.println("7. Load compilation from file.");
            System.out.println("8. Exit.");

            System.out.print("Enter an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Очистити буфер

            switch (choice) {
                case 1:
                    commandManager.runCommand(displayTracks);
                    break;
                case 2:
                    commandManager.runCommand(addTrack);
                    break;
                case 3:
                    commandManager.runCommand(removeTrack);
                    break;
                case 4:
                    commandManager.runCommand(sortByStyle);
                    break;
                case 5:
                    commandManager.runCommand(searchByDuration);
                    break;
                case 6:
                    commandManager.runCommand(saveCompilation);
                    break;
                case 7:
                    commandManager.runCommand(loadCompilation);
                    break;
                case 8:
                    System.out.println("Exiting program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
