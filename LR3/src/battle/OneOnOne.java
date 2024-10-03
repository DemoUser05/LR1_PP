package src.battle;

import src.droids.Droid;
import src.fileWork.FileWork;

import java.util.Scanner;

public class OneOnOne {
    private Droid[] droid1;
    private Droid[] droid2;
    private StringBuilder battleLog;  // Змінна для запису логу битви

    public OneOnOne(Droid[] droid1, Droid[] droid2) {
        this.droid1 = droid1;
        this.droid2 = droid2;
        this.battleLog = new StringBuilder();  // Ініціалізація логу битви
    }

    public void start() {
        // Виведення повідомлення перед початком бою
        System.out.println("Happy Droids Games! And may the odds be ever in your favor");
        battleLog.append("Happy Droids Games! And may the odds be ever in your favor\n");

        System.out.println("Бій між " + droid1[0].getName() + " та " + droid2[0].getName() + " розпочато!");
        battleLog.append("Бій між ").append(droid1[0].getName()).append(" та ").append(droid2[0].getName()).append(" розпочато!\n");

        // Битва продовжується, поки один із дроїдів не загине
        while (droid1[0].isAlive() && droid2[0].isAlive()) {
            // Атака дроїда 1 на дроїда 2
            droid1[0].attack(droid2[0]);
            battleLog.append(droid1[0].getName()).append(" атакує ").append(droid2[0].getName()).append("\n");

            // Перевірка, чи дроїд 2 ще живий
            if (droid2[0].isAlive()) {
                // Атака дроїда 2 на дроїда 1
                droid2[0].attack(droid1[0]);
                battleLog.append(droid2[0].getName()).append(" атакує ").append(droid1[0].getName()).append("\n");
            }
        }

        // Перевіряємо, хто переміг
        if (droid1[0].isAlive()) {
            System.out.println(droid1[0].getName() + " переміг!");
            battleLog.append(droid1[0].getName()).append(" переміг!\n");
        } else {
            System.out.println(droid2[0].getName() + " переміг!");
            battleLog.append(droid2[0].getName()).append(" переміг!\n");
        }

        // Запит на введення імені файлу для збереження результатів
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть назву файлу для запису результатів бою:");
        String fileName = scanner.nextLine();

        // Запис логу битви у файл
        FileWork.writeBattleLogToFile(battleLog.toString(), fileName);
    }
}
