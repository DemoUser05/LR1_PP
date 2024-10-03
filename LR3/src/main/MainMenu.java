package src.main;

import src.battle.OneOnOne;
import src.battle.TeamBattle;
import src.droids.Droid;
import src.droids.MedicDroid;
import src.droids.ShooterDroid;
import src.droids.WarriorDroid;
import src.fileWork.FileWork;

import java.util.Scanner;

public class MainMenu {
    private static Droid[] droids = new Droid[10];  // Масив для зберігання максимум 10 дроїдів
    private static int droidCount = 0;  // Лічильник створених дроїдів
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Створити дроїда");
            System.out.println("2. Показати список дроїдів");
            System.out.println("3. Бій 1 на 1");
            System.out.println("4. Бій команда на команду");
            System.out.println("5. Записати проведений бій у файл");
            System.out.println("6. Відтворити проведений бій зі збереженого файлу");
            System.out.println("7. Вийти");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> createDroid();
                case 2 -> showDroids();
                case 3 -> fightOneOnOne();
                case 4 -> fightTeamBattle();
                case 5 -> writeBattleToFile();
                case 6 -> readBattleFromFile();
                case 7 -> {
                    System.out.println("Вихід...");
                    return;
                }
                default -> System.out.println("Неправильний вибір, спробуйте ще раз.");
            }
        }
    }

    // Метод для створення дроїда і додавання в масив
    private static void createDroid() {
        if (droidCount >= droids.length) {
            System.out.println("Максимальна кількість дроїдів досягнута.");
            return;
        }

        int type = -1;
        while (type < 1 || type > 3) {
            System.out.println("Оберіть тип дроїда:");
            System.out.println("1. Воїн");
            System.out.println("2. Медик");
            System.out.println("3. Снайпер");
            if (scanner.hasNextInt()) {
                type = scanner.nextInt();
                if (type < 1 || type > 3) {
                    System.out.println("Неправильний вибір типу дроїда. Введіть число від 1 до 3.");
                }
            } else {
                System.out.println("Неправильний формат введення. Введіть число від 1 до 3.");
                scanner.next();
            }
        }

        System.out.println("Введіть ім'я дроїда:");
        String name = scanner.next();

        Droid droid = switch (type) {
            case 1 -> new WarriorDroid(name);
            case 2 -> new MedicDroid(name);
            case 3 -> new ShooterDroid(name);
            default -> throw new IllegalStateException("Неправильний вибір типу дроїда");
        };

        droids[droidCount] = droid;
        droidCount++;
        System.out.println("Дроїд " + name + " створений.");
    }

    // Показуємо список створених дроїдів
    private static void showDroids() {
        if (droidCount == 0) {
            System.out.println("Дроїди ще не створені.");
            return;
        }

        System.out.println("Список створених дроїдів:");
        for (int i = 0; i < droidCount; i++) {
            Droid droid = droids[i];
            System.out.println((i + 1) + ". " + droid.getName() + " (Здоров'я: " + droid.getHealth() + ", Пошкодження: " + droid.getDamage() + ")");
        }
    }

    // Метод для бою 1 на 1
    private static void fightOneOnOne() {
        if (droidCount < 2) {
            System.out.println("Недостатньо дроїдів для бою.");
            return;
        }

        System.out.println("Оберіть двох дроїдів для бою 1 на 1:");
        showDroids();
        int droid1Index = scanner.nextInt() - 1;
        int droid2Index = scanner.nextInt() - 1;

        if (droid1Index < 0 || droid1Index >= droidCount || droid2Index < 0 || droid2Index >= droidCount || droid1Index == droid2Index) {
            System.out.println("Неправильний вибір дроїдів.");
            return;
        }

        OneOnOne battle = new OneOnOne(new Droid[]{droids[droid1Index]}, new Droid[]{droids[droid2Index]});
        battle.start();
    }

    // Метод для бою команда на команду
    private static void fightTeamBattle() {
        if (droidCount < 4) {
            System.out.println("Недостатньо дроїдів для бою команд.");
            return;
        }

        Droid[] team1 = new Droid[2];
        Droid[] team2 = new Droid[2];
        boolean[] selectedDroids = new boolean[droidCount];  // Масив для перевірки вибраних дроїдів

        // Вибір дроїдів для Команди 1
        System.out.println("Оберіть дроїдів для Команди 1:");
        for (int i = 0; i < team1.length; i++) {
            printAvailableDroids(selectedDroids);  // Виводимо доступних дроїдів перед кожним вибором
            int index = getValidDroidIndex(selectedDroids);
            team1[i] = droids[index];
            selectedDroids[index] = true;
            System.out.println(droids[index].getName() + " додано до Команди 1.");
        }

        // Вибір дроїдів для Команди 2
        System.out.println("Оберіть дроїдів для Команди 2:");
        for (int i = 0; i < team2.length; i++) {
            printAvailableDroids(selectedDroids);  // Виводимо доступних дроїдів перед кожним вибором
            int index = getValidDroidIndex(selectedDroids);
            team2[i] = droids[index];
            selectedDroids[index] = true;
            System.out.println(droids[index].getName() + " додано до Команди 2.");
        }

        System.out.println("Формування команд завершено. Починається бій!");
        TeamBattle teamBattle = new TeamBattle(team1, team2);
        teamBattle.start();
    }

    // Метод для виведення списку дроїдів з позначками, чи вибрані вони
    private static void printAvailableDroids(boolean[] selectedDroids) {
        System.out.println("Доступні дроїди:");
        for (int i = 0; i < droidCount; i++) {
            if (selectedDroids[i]) {
                System.out.println((i + 1) + ". " + droids[i].getName() + " (вибраний)");
            } else {
                System.out.println((i + 1) + ". " + droids[i].getName() + " (доступний)");
            }
        }
    }

    // Метод для отримання індексу дроїда
    private static int getValidDroidIndex(boolean[] selectedDroids) {
        int index = -1;
        while (true) {
            System.out.println("Введіть індекс дроїда:");
            if (scanner.hasNextInt()) {
                index = scanner.nextInt() - 1;
                if (index >= 0 && index < droidCount && !selectedDroids[index]) {
                    return index;  // Коректний індекс
                } else {
                    System.out.println("Неправильний індекс або дроїд вже обраний.");
                }
            } else {
                System.out.println("Неправильний формат. Введіть число.");
                scanner.next();
            }
        }
    }

    // Метод для запису результатів бою у файл
    private static void writeBattleToFile() {
        System.out.println("Функція запису результатів бою у файл.");
        // Цей функціонал вже реалізований у класах BattleOneOnOne і TeamBattle
    }

    // Метод для зчитування результатів бою з файлу
    private static void readBattleFromFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть назву файлу для зчитування результатів бою:");
        String fileName = scanner.nextLine();
        String log = FileWork.readBattleLogFromFile(fileName);
        System.out.println("Результати бою:\n" + log);
    }
}
