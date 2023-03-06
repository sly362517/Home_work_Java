// Задано уравнение вида q + w = e, q, w, e >= 0.
// Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69 (пользователь).
// Требуется восстановить выражение до верного равенства.
// Предложить хотя бы одно решение или сообщить, что его нет.
// Ввод: 2? + ?5 = 69
// Вывод: 24 + 45 = 69
package Home_work_Java.home_work1;

import java.util.Scanner;

public class task4 {
    static boolean is_equal(String q, String w, String e) {
        int a = Integer.parseInt(q);
        int b = Integer.parseInt(w);
        int c = Integer.parseInt(e);
        if (a + b == c) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.printf("Введите уравнение в виде (q + w = e): ");
        String equation = scn.nextLine();
        equation = equation.replace(" ", "");
        String[] numbers_array = equation.split("[+=]");
        boolean is_correct_input = true;

        for (String element : numbers_array) {
            element = element.replace("?", "0");
            int number = Integer.parseInt(element);
            if (number < 0) {
                is_correct_input = false;
                break;
            }           
        }

        if (!is_correct_input || numbers_array.length != 3) {
            System.out.println("Вы вводите неправильное уравнение");
        } else {
            boolean is_solution = false;
            for (int x = 0; x < 10; x++) {
                String[] temp_array = numbers_array.clone();
                for (int i = 0; i < 3; i++) {
                    String c = Integer.toString(x);
                    temp_array[i] = temp_array[i].replace("?", c);
                    //System.out.println(temp_array[i]);
                }

                if (task4.is_equal(temp_array[0], temp_array[1], temp_array[2])) {
                    System.out.printf("%s + %s = %s", temp_array[0], temp_array[1], temp_array[2]);
                    is_solution = true;
                    break;
                }                
            }
            if (! is_solution) {
               System.out.println("Решение уравнения отсутствует"); 
            } 
        }
        scn.close();
    }
}

