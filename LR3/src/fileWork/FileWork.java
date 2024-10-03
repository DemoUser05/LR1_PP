package src.fileWork;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWork {

    // Метод для запису результатів битви у файл
    public static void writeBattleLogToFile(String log, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(log);
            System.out.println("Результати битви записано у файл: " + fileName);
        } catch (IOException e) {
            System.out.println("Помилка при записі у файл: " + e.getMessage());
        }
    }

    // Метод для зчитування результатів битви з файлу
    public static String readBattleLogFromFile(String fileName) {
        StringBuilder log = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                log.append(line).append("\n");
            }
            System.out.println("Результати битви зчитано з файлу: " + fileName);
        } catch (IOException e) {
            System.out.println("Помилка при зчитуванні з файлу: " + e.getMessage());
        }
        return log.toString();  // Повертаємо текст логу
    }
}


