package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите выражение: ");

        double a = scanner.nextDouble();
        char op = scanner.next().charAt(0);
        double b = scanner.nextDouble();

        double result = 0;

        if (op == '+') {
            result = a + b;
        }
        System.out.println("Результат: " + result);
        scanner.close();
    }
}
