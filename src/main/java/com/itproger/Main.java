package com.itproger;
import java.util.Scanner;

class LucasNumber {
    public int n;      // Номер числа Люка
    public int value;  // Значення числа Люка

    // Конструктор, який ініціалізує n і обчислює відповідне число Люка
    public LucasNumber(int n) {
        this.n = n;
        this.value = calculateLucasNumber(n);
    }

    // Метод для обчислення числа Люка тільки для N <= 0
    private int calculateLucasNumber(int n) {
        if (n == 0) return 2;  // L(0) = 2
        if (n == -1) return 1;  // L(-1) = 1

        // Якщо N від'ємне, використовуємо формулу L(-n) = (-1)^n * L(n)
        // Оскільки n від'ємне, ми використовуємо тільки формулу для від'ємних індексів
        n = Math.abs(n);  // Беремо абсолютне значення N
        int prev = 2;     // L(0)
        int curr = 1;     // L(1)
        int next;

        for (int i = 2; i <= n; i++) {
            next = prev + curr;
            prev = curr;
            curr = next;
        }

        // Для від'ємних індексів: L(-n) = (-1)^n * L(n)
        return (n % 2 == 0) ? curr : -curr;  // Якщо n парне, результат позитивний, інакше негативний
    }

    // Метод для отримання обчисленого значення числа Люка
    public int getValue() {
        return value;
    }

    // Метод для отримання номера числа Люка
    public int getNumber() {
        return n;
    }

    // Головна функція для запуску програми
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Введення користувачем номера числа Люка (N)
        System.out.print("Введіть номер числа Люка (N ≤ 0): ");
        int n = scanner.nextInt();

        // Перевірка на допустимий діапазон N
        if (n > 0) {
            System.out.println("Помилка: N повинно бути менше або дорівнювати нулю!");
        } else {
            LucasNumber lucas = new LucasNumber(n);
            System.out.println("N-е число Люка для N = " + lucas.getNumber() + " : " + lucas.getValue());
        }
    }
}
