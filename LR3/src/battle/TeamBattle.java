package src.battle;

import src.droids.Droid;
import src.fileWork.FileWork;

import java.util.Scanner;

public class TeamBattle {
    private Droid[] team1;
    private Droid[] team2;
    private StringBuilder battleLog;

    public TeamBattle(Droid[] team1, Droid[] team2) {
        this.team1 = team1;
        this.team2 = team2;
        this.battleLog = new StringBuilder();
    }

    public void start() {
        // Виведення повідомлення перед початком бою
        System.out.println("Happy Droids Games! And may the odds be ever in your favor");
        battleLog.append("Happy Droids Games! And may the odds be ever in your favor\n");

        System.out.println("Бій команда на команду розпочато!");
        battleLog.append("Бій команда на команду розпочато!\n");

        // Битва команд
        while (isTeamAlive(team1) && isTeamAlive(team2)) {
            Droid attacker1 = selectAliveDroid(team1);
            Droid attacker2 = selectAliveDroid(team2);

            if (attacker1 != null && attacker2 != null) {
                attacker1.attack(attacker2);
                battleLog.append(attacker1.getName()).append(" атакує ").append(attacker2.getName()).append("\n");

                if (!attacker2.isAlive()) {
                    System.out.println(attacker2.getName() + " з команди 2 загинув!");
                    battleLog.append(attacker2.getName()).append(" з команди 2 загинув!\n");
                }

                if (isTeamAlive(team2)) {
                    attacker2.attack(attacker1);
                    battleLog.append(attacker2.getName()).append(" атакує ").append(attacker1.getName()).append("\n");

                    if (!attacker1.isAlive()) {
                        System.out.println(attacker1.getName() + " з команди 1 загинув!");
                        battleLog.append(attacker1.getName()).append(" з команди 1 загинув!\n");
                    }
                }
            }
        }

        // Виведення результату
        if (isTeamAlive(team1)) {
            System.out.println("Команда 1 перемогла!");
            battleLog.append("Команда 1 перемогла!\n");
        } else {
            System.out.println("Команда 2 перемогла!");
            battleLog.append("Команда 2 перемогла!\n");
        }

        // Запит на введення імені файлу для збереження результатів
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть назву файлу для запису результатів бою:");
        String fileName = scanner.nextLine();

        // Запис логу битви у файл
        FileWork.writeBattleLogToFile(battleLog.toString(), fileName);
    }

    private boolean isTeamAlive(Droid[] team) {
        for (Droid droid : team) {
            if (droid != null && droid.isAlive()) {
                return true;
            }
        }
        return false;
    }

    private Droid selectAliveDroid(Droid[] team) {
        for (Droid droid : team) {
            if (droid != null && droid.isAlive()) {
                return droid;
            }
        }
        return null;
    }
}
