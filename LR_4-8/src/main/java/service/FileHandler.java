package service;

import model.Track;

import java.io.*;
import java.util.List;

public class FileHandler {
    public void saveToFile(List<Track> tracks, String filename) {
        // Переконайтеся, що список треків не порожній
        if (tracks.isEmpty()) {
            System.out.println("No tracks to save.");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Track track : tracks) {
                writer.write(track.getName() + "," + track.getDuration() + "," + track.getStyle());
                writer.newLine();
            }
            System.out.println("Tracks saved to file: " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Ваш метод loadFromFile залишився без змін
    public void loadFromFile(List<Track> tracks, String filename) {
        tracks.clear(); // Очищаємо список перед завантаженням
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String name = parts[0];
                    double duration = Double.parseDouble(parts[1]);
                    String style = parts[2];
                    tracks.add(new Track(name, duration, style));
                }
            }
            System.out.println("Tracks loaded from file: " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
