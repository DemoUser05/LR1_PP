package service;

import model.Track;
import model.TrackManager;

import java.util.List;
import java.util.Scanner;

public class SaveCompilationCommand implements Command {
    private TrackManager trackManager; // Використовуємо TrackManager
    private Scanner scanner; // Додати сканер для вводу

    public SaveCompilationCommand(TrackManager trackManager, Scanner scanner) {
        this.trackManager = trackManager; // Ініціалізувати TrackManager
        this.scanner = scanner; // Ініціалізувати сканер
    }

    @Override
    public void execute() {
        System.out.print("Enter the file path to save the compilation: ");
        String filePath = scanner.nextLine(); // Отримати шлях від користувача
        FileHandler fileHandler = new FileHandler();
        List<Track> tracks = trackManager.getTracks(); // Отримати треки з TrackManager
        fileHandler.saveToFile(tracks, filePath); // Записати треки у файл
    }
}


