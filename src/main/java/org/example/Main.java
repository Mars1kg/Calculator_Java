import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final String HISTORY_FILE = "history.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> history = loadHistory();

        while (true) {
            try {
                System.out.print("Введите выражение ('exit' - выход, 'history' - просмотр истории): ");
                if (scanner.hasNext("exit")) {
                    saveHistory(history);
                    System.out.println("Выход из программы.");
                    break;
                }
                if (scanner.hasNext("history")) {
                    System.out.println("История вычислений:");
                    for (String entry : history) {
                        System.out.println(entry);
                    }
                    scanner.next();
                    continue;
                }

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

                if (Double.isNaN(result)) {
                    System.out.println("Ошибка: неподдерживаемая операция.");
                } else {
                    String record = a + " " + op + " " + b + " = " + result;
                    if (history.size() >= 10) history.remove(0);
                    history.add(record);
                    System.out.println("Результат: " + result);
                }

            } catch (Exception e) {
                System.out.println("Ошибка ввода! Попробуйте снова.");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    private static ArrayList<String> loadHistory() {
        ArrayList<String> history = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(HISTORY_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                history.add(line);
            }
        } catch (IOException ignored) {
        }
        return history;
    }

    private static void saveHistory(ArrayList<String> history) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(HISTORY_FILE))) {
            for (String entry : history) {
                writer.write(entry);
                writer.newLine();
            }
        } catch (IOException ignored) {
        }
    }
}
