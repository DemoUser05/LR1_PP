package com.itproger;
import java.util.Scanner;

class LucasNumber {
    private int N;
    private int value;

    //Конструктор
    public LucasNumber(int N) {
        this.N = N;
        this.value = calculateLucasNumber(N);
    }

    // Метод для обчислення числа Люка за індексом
    private int calculateLucasNumber(int N) {
        if(N == 0) return 2;
        if(N == 1) return 1;

        int prev = 2;
        int curr = 1;
        int next = 0;

        for(int i = 2; i<=N; i++) {
            next = prev + curr;
            prev = curr;
            curr = next;
        }
        return curr;
    }
    // Метод для отримання значення числа Люка
    public int getValue() {
        return value;
    }

    // Метод для отримання значення числа Люка
    public int getNumber() {
        return N;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Введення номеру числа Люка
        System.out.print("Введіть номер число Люка (N): ");
        int N = scanner.nextInt();

        // Перевіряємо коректність введеного числа
        if(N < 0) {
            System.out.println("Помилка. Число N має бути більше або дорівнювати 0.");
            return;
        }

        // Створюємо об'єкт класу LucasNumber
        LucasNumber number = new LucasNumber(N);

        //Виведення результату
        System.out.println("N-е число Люка для N = " + number.getNumber() + " є " + number.getValue());
    }
}
