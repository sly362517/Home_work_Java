package Home_work_Java.home_work1;

import java.util.Scanner;

public class task1 {
    static int get_triangle_number(int n) {
        int sum = 0;
        for (int index = 0; index < n; index++) {
            sum += index + 1;
        }
        return sum;
    }

    static int get_factorial(int n) {
        int result = 1;
        for (int index = 0; index < n; index++) {
            result *= index + 1;
        }
        return result; 
    }

    public static void main (String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = 0;
        System.out.printf("Введите натуральное число: ");
        if (!scn.hasNextInt()) {
            System.out.println("Вы ввели неправильное чмсло!");
        } else {
            n = scn.nextInt();
            if (n < 1)
                System.out.println("Вы должны ввести только положительное число!");
            else {
                System.out.printf("Треугольное число %d равно: %s! ", n, task1.get_triangle_number(n));
                System.out.println();
                System.out.printf("Факториал %d равен: %s! ", n, task1.get_factorial(n));
            }
        }
        scn.close();
    }
}