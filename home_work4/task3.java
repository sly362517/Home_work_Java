// 3. В калькулятор добавьте возможность отменить последнюю операцию.
// Пример
// 1 
// + 
// 2
// ответ:
// 3
// +
// 4
// ответ:
// 7
// Esc
// 3
// *
// 3
// ответ:
// 9
// Пример 2
// Ввод: 1
// Ввод: +
// Ввод: 2
// Вывод: 3
// Ввод:+
// Ввод:4
// Вывод 7
// Ввод:*
// Ввод:3
// Вывод 21
// Esc
// Вывод 7
// Esc
// Вывод 3
// Ввод:-
// Ввод:1
// Вывод 2
// ***Дополнительно*** каскадная отмена - отмена нескольких операций
package Home_work_Java.home_work4;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class task3 {
    static double getSum(double a, double b) {
        return a + b;
    }

    static double getSubtraction(double a, double b) {
        return a - b;
    }

    static double getProduct(double a, double b) {
        return a * b;
    }

    static double getDivision(double a, double b) {
        return a / b;
    }

    static double getResultOfOperation(double a, double b, String signOperation) {
        switch (signOperation) {
            case "+":
                return (double) getSum(a, b);
            case "-":
                return (double) getSubtraction(a, b);
            case "*":
                return (double) getProduct(a, b);
            case "/":
                return (double) getDivision(a, b);
            default:
                return 0;
        }
    }

    static boolean isSignOperation(String signOperation) {
        if (signOperation.equals("+") || signOperation.equals("-") || signOperation.equals("*")
                || signOperation.equals("/")) {
            return true;
        }
        return false;
    }

    static boolean isEscape(String str) {
        if (str.equals("Esc")) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Deque<Double> listResults = new LinkedList<Double>();
        Scanner scn = new Scanner(System.in);
        System.out.printf(
                " Здравствуйте! Вы можете воспользоваться калькулятором!\n После ввода первого числа необходимо ввести оперрацию из списка{ +, -, *, /}. \n Вы можете отменить последнюю операцию, введя 'Esc'.\n");
        try {
            System.out.printf("Введите первое число: ");
            double a = Double.parseDouble(scn.nextLine());
            listResults.addLast(a);
            while (scn.hasNextLine()) {
                String nextElement = scn.nextLine();
                while (isEscape(nextElement) && listResults.size() > 0) {
                    if (listResults.size() == 1) {
                        System.out.println("Отмена последней операции!");
                    } else {
                        listResults.pollLast();
                    }
                    System.out.printf("%.2f \n", listResults.getLast());
                    nextElement = scn.nextLine();
                }

                if (!isSignOperation(nextElement)) {
                    System.out.println("Вы ввели неправильную операцию!");
                    continue;
                }
                String sign_operation = nextElement;
                double b = Double.parseDouble(scn.nextLine());
                if (b == 0 && sign_operation.equals("/")) {
                    System.out.println("Делить на 0 нельзя!");
                } else {
                    double result = getResultOfOperation(listResults.getLast(), b, sign_operation);
                    listResults.addLast(result);
                    System.out.println(result);
                    continue;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        scn.close();
    }
}
