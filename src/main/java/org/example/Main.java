package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите выражение: ");

        double a = scanner.nextDouble();
        char op = scanner.next().charAt(0);
        double b = scanner.hasNextDouble() ? scanner.nextDouble() : 0;

        double result = switch (op) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> (b != 0) ? a / b : Double.NaN;
            case '%' -> a % b;
            case 'p' -> Math.pow(a, b);
            case 's' -> Math.sqrt(a);
            case 'a' -> Math.abs(a);
            case 'r' -> Math.round(a);
            default -> Double.NaN;
        };

        System.out.println("Результат: " + result);
        scanner.close();
    }
}


