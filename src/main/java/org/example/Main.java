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

        switch (op) {
            case '+': result = a + b; break;
            case '-': result = a - b; break;
            case '*': result = a * b; break;
            case '/': result = a / b; break;
            case '%': result = a % b; break;
            default:
                System.out.println("Ошибка: неподдерживаемая операция.");
                return;
        }

        System.out.println("Результат: " + result);
        scanner.close();
    }
}

