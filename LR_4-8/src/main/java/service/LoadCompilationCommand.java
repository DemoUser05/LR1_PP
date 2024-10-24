package service;

import model.Track;

import java.util.List;
import java.util.Scanner;

public class LoadCompilationCommand implements Command {
    private List<Track> tracks;
    private Scanner scanner; // Додати сканер для вводу

    public LoadCompilationCommand(List<Track> tracks, Scanner scanner) {
        this.tracks = tracks;
        this.scanner = scanner; // Ініціалізувати сканер
    }

    @Override
    public void execute() {
        System.out.print("Enter the file path to load the compilation: ");
        String filePath = scanner.nextLine(); // Отримати шлях від користувача
        FileHandler fileHandler = new FileHandler();
        fileHandler.loadFromFile(tracks, filePath);
        System.out.println("Tracks loaded from " + filePath + " successfully.");

        // Вивести треки на екран
        System.out.println("Loaded Tracks:");
        if (tracks.isEmpty()) {
            System.out.println("No tracks available.");
        } else {
            for (Track track : tracks) {
                System.out.println(track); // Виклик toString для кожного треку
            }
        }
    }
}
