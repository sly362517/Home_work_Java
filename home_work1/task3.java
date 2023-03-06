// Реализовать простой калькулятор (+ - / *)
// Ввод числа ->
// Ввод знака ->
// Ввод числа ->
package Home_work_Java.home_work1;

import java.util.Scanner;

public class task3 {
    static int get_sum(int a, int b) {
        return a + b;
    }

    static int get_subtraction(int a, int b) {
        return a - b;
    }

    static int get_product(int a, int b) {
        return a * b;
    }

    static double get_division(int a, int b) {
        return (double) a / (double) b;
    }

    static void print_result_of_operation(int a, int b, String sign_operation) {
        switch (sign_operation) {
        case "+":
            System.out.printf("%d %s %d = %d \n", a, sign_operation, b, get_sum(a, b));
            break;
        case "-":
            System.out.printf("%d %s %d = %d \n", a, sign_operation, b, get_subtraction(a, b));
            break;
        case "*":
            System.out.printf("%d %s %d = %d \n", a, sign_operation, b, get_product(a, b));
            break;
        case "/":
            if (b != 0) {
                System.out.printf("%d %s %d = %.4333f \n", a, sign_operation, b, get_division(a, b));
            } else {
                System.out.println("Нельзя делить на 0");
            }
            break;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.printf("Введите первое число: ");
        int a = 0;
        if (!scn.hasNextInt()) {
            System.out.println("Вы ввели неправильное число");
        } else {
            a = scn.nextInt();
            Scanner sc = new Scanner(System.in);
            System.out.printf("Введите знак из списка: +, -, *, / \n");
            String sign_operation = "";
            if (sc.hasNextLine()) {
                sign_operation = sc.nextLine();
            }
            if (sign_operation.equals("+") || sign_operation.equals("-") || sign_operation.equals("*")
                    || sign_operation.equals("/")) {
                int b = 0;
                System.out.printf("Введите второе число: ");
                if (!scn.hasNextInt()) {
                    System.out.println("Вы ввели неправильное число");
                } else {
                    b = scn.nextInt();
                    task3.print_result_of_operation(a, b, sign_operation);
                }
            } else {
                System.out.println("Вы ввели неправильный знак");
            }
            scn.close();
            sc.close();
        }
    }
}
