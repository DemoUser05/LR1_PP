package main;

import train.Train;
import java.util.Scanner;


public class Main {

    // Метод для виведення поїздів до заданого пункту призначення
    public static void printTrainsByDestination(Train[] trains, String destination) {
        System.out.println("Поїзди до пункту призначення: " + destination);
        for (Train train : trains) {
            if (train.getDestination().equalsIgnoreCase(destination)) {
                System.out.println(train);
            }
        }
    }

    // Метод для виведення поїздів до заданого пункту призначення, які відправляються після заданої години
    public static void printTrainsByDestinationAndTime(Train[] trains, String destination, String time) {
        System.out.println("Поїзди до пункту призначення: " + destination + ", які відправляються після " + time);
        for (Train train : trains) {
            if (train.getDestination().equalsIgnoreCase(destination) && train.getDepartureTime().compareTo(time) > 0) {
                System.out.println(train);
            }
        }
    }

    // Метод для виведення поїздів до заданого пункту призначення, які мають загальні місця
    public static void printTrainsWithGeneralSeats(Train[] trains, String destination) {
        System.out.println("Поїзди до пункту призначення: " + destination + ", які мають загальні місця:");
        for (Train train : trains) {
            if (train.getDestination().equalsIgnoreCase(destination) && train.getGeneralSeats() > 0) {
                System.out.println(train);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Введення кількості поїздів
        int trainCount;
        while (true) {
            System.out.print("Введіть кількість поїздів: ");
            if (scanner.hasNextInt()) {
                trainCount = scanner.nextInt();
                if (trainCount > 0) {
                    break;
                } else {
                    System.out.println("Помилка: кількість поїздів повинна бути більше нуля.");
                }
            } else {
                System.out.println("Помилка: введіть ціле число.");
                scanner.next();
            }
        }

        // Створення масиву для зберігання поїздів
        Train[] trains = new Train[trainCount];

        // Введення інформації про кожен поїзд з валідацією
        for (int i = 0; i < trainCount; i++) {
            System.out.println("Введіть інформацію для поїзда " + (i + 1));

            // Введення пункту призначення
            String destination;
            while (true) {
                System.out.print("Пункт призначення: ");
                destination = scanner.next();

                // Перевірка, чи введений рядок містить тільки літери
                if (destination.matches("[a-zA-Zа-яА-ЯіІїЇєЄЙй']+")) {
                    break; // Якщо введення коректне, виходимо з циклу
                } else {
                    System.out.println("Помилка: пункт призначення повинен містити тільки літери.");
                }
            }

            // Введення номера поїзда
            int trainNumber;
            while (true) {
                System.out.print("Номер поїзда: ");
                if (scanner.hasNextInt()) {
                    trainNumber = scanner.nextInt();
                    if (trainNumber > 0) {
                        break;
                    } else {
                        System.out.println("Помилка: номер поїзда повинен бути більше нуля.");
                    }
                } else {
                    System.out.println("Помилка: введіть ціле число.");
                    scanner.next();
                }
            }

            // Введення часу відправки
            String departureTime;
            while (true) {
                System.out.print("Час відправки (наприклад, 14:30): ");
                departureTime = scanner.next();
                if (departureTime.matches("^([01]?\\d|2[0-3]):[0-5]\\d$")) {
                    break;
                } else {
                    System.out.println("Помилка: введіть час у форматі ГГ:ХХ.");
                }
            }

            // Введення кількості загальних місць
            int generalSeats;
            while (true) {
                System.out.print("Кількість загальних місць: ");
                if (scanner.hasNextInt()) {
                    generalSeats = scanner.nextInt();
                    if (generalSeats >= 0) {
                        break;
                    } else {
                        System.out.println("Помилка: кількість місць повинна бути більше або дорівнювати нулю.");
                    }
                } else {
                    System.out.println("Помилка: введіть ціле число.");
                    scanner.next(); // Очищуємо некоректне введення
                }
            }

            // Введення кількості місць у купе
            int coupeSeats;
            while (true) {
                System.out.print("Кількість місць у купе: ");
                if (scanner.hasNextInt()) {
                    coupeSeats = scanner.nextInt();
                    if (coupeSeats >= 0) {
                        break;
                    } else {
                        System.out.println("Помилка: кількість місць повинна бути більше або дорівнювати нулю.");
                    }
                } else {
                    System.out.println("Помилка: введіть ціле число.");
                    scanner.next(); // Очищуємо некоректне введення
                }
            }

            // Введення кількості плацкартних місць
            int platskartSeats;
            while (true) {
                System.out.print("Кількість плацкартних місць: ");
                if (scanner.hasNextInt()) {
                    platskartSeats = scanner.nextInt();
                    if (platskartSeats >= 0) {
                        break;
                    } else {
                        System.out.println("Помилка: кількість місць повинна бути більше або дорівнювати нулю.");
                    }
                } else {
                    System.out.println("Помилка: введіть ціле число.");
                    scanner.next(); // Очищуємо некоректне введення
                }
            }

            // Введення кількості місць люкс
            int luxurySeats;
            while (true) {
                System.out.print("Кількість місць люкс: ");
                if (scanner.hasNextInt()) {
                    luxurySeats = scanner.nextInt();
                    if (luxurySeats >= 0) {
                        break;
                    } else {
                        System.out.println("Помилка: кількість місць повинна бути більше або дорівнювати нулю.");
                    }
                } else {
                    System.out.println("Помилка: введіть ціле число.");
                    scanner.next(); // Очищуємо некоректне введення
                }
            }

            // Створення та додавання поїзда до масиву
            trains[i] = new Train(destination, trainNumber, departureTime, generalSeats, coupeSeats, platskartSeats, luxurySeats);
        }

        // Виклик методів для фільтрації та виведення поїздів
        System.out.print("Введіть пункт призначення для фільтрації поїздів: ");
        String filterDestination = scanner.next();
        printTrainsByDestination(trains, filterDestination);

        System.out.print("Введіть час для фільтрації поїздів, що відправляються після цього часу: ");
        String filterTime = scanner.next();
        printTrainsByDestinationAndTime(trains, filterDestination, filterTime);

        // Виводимо поїзди з загальними місцями
        printTrainsWithGeneralSeats(trains, filterDestination);

        scanner.close();
    }
}

