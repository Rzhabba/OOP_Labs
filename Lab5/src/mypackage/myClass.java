package mypackage;

import java.util.Scanner;

public class myClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Калькулятор");
        System.out.print("Введите первое число: ");
        String input1 = scanner.nextLine();

        System.out.print("Введите второе число: ");
        String input2 = scanner.nextLine();

        System.out.print("Введите операцию (+, -, *, /): ");
        String operation = scanner.nextLine();

        try {
            double num1 = Double.parseDouble(input1);
            double num2 = Double.parseDouble(input2);
            double result;

            switch (operation) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0) {
                        throw new ArithmeticException("Деление на ноль запрещено!");
                    }
                    result = num1 / num2;
                    break;
                default:
                    System.out.println("Неподдерживаемая операция: " + operation);
                    return;
            }

            System.out.println("Результат: " + result);
            return;

        } catch (NumberFormatException e) {
            System.out.println("Ошибка: Введено не число. Пожалуйста, введите корректные числовые значения.");
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}