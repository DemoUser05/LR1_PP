package main;

import model.TrackManager;
import service.*;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
    private static final Logger logger = LoggerConfig.getLogger(); // Ініціалізація логера

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    public void run() {
        TrackManager trackManager = new TrackManager();  // Менеджер для роботи з треками
        Scanner scanner = new Scanner(System.in);

        // Створення команд для виконання різних дій
        Command addTrack = new AddTrackCommand(trackManager, scanner);
        Command removeTrack = new RemoveTrackCommand(trackManager, scanner);
        Command sortByStyle = new SortTracksByStyleCommand(trackManager);
        Command searchByDuration = new SearchTracksByDurationCommand(trackManager, scanner);
        Command displayTracks = new DisplayTracksCommand(trackManager);
        Command saveCompilation = new SaveCompilationCommand(trackManager, scanner);
        Command loadCompilation = new LoadCompilationCommand(trackManager.getTracks(), scanner);

        CommandManager commandManager = new CommandManager();

        while (true) {
            try {
                // Відображення меню
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
                scanner.nextLine();  // Очищення буфера

                // Виклик обробника вибору користувача
                processUserChoice(choice, commandManager, addTrack, removeTrack, sortByStyle,
                        searchByDuration, displayTracks, saveCompilation, loadCompilation, scanner);

            } catch (Exception e) {
                logger.log(Level.SEVERE, "Unexpected error in main menu", e);
                System.out.println("An error occurred. Please try again.");
            }
        }
    }

    // Метод для обробки вибору користувача
    public void processUserChoice(int choice, CommandManager commandManager, Command addTrack,
                                  Command removeTrack, Command sortByStyle, Command searchByDuration,
                                  Command displayTracks, Command saveCompilation, Command loadCompilation,
                                  Scanner scanner) {
        switch (choice) {
            case 1:
                commandManager.runCommand(displayTracks);
                logger.log(Level.INFO, "Displayed all tracks.");
                break;
            case 2:
                commandManager.runCommand(addTrack);
                logger.log(Level.INFO, "Added a new track.");
                break;
            case 3:
                commandManager.runCommand(removeTrack);
                logger.log(Level.INFO, "Attempted to remove a track.");
                break;
            case 4:
                commandManager.runCommand(sortByStyle);
                logger.log(Level.INFO, "Sorted tracks by style.");
                break;
            case 5:
                commandManager.runCommand(searchByDuration);
                logger.log(Level.INFO, "Searched tracks by duration.");
                break;
            case 6:
                commandManager.runCommand(saveCompilation);
                logger.log(Level.INFO, "Saved compilation to file.");
                break;
            case 7:
                commandManager.runCommand(loadCompilation);
                logger.log(Level.INFO, "Loaded compilation from file.");
                break;
            case 8:
                System.out.println("Exiting program.");
                logger.log(Level.INFO, "Exited the program.");
                scanner.close();
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                logger.log(Level.WARNING, "User entered an invalid menu option.");
        }
    }
}

