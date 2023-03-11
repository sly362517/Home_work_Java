// К калькулятору из предыдущего дз добавить логирование.
// 1 + 3 = 4
// 4 + 3 = 7
package Home_work_Java.home_work2;

import java.io.FileWriter;
import java.io.IOException;
import java.text.Format;
import java.util.Scanner;

public class task3 {
    static int getSum(int a, int b) {
        return a + b;
    }

    static int getSubtraction(int a, int b) {
        return a - b;
    }

    static int getProduct(int a, int b) {
        return a * b;
    }

    static double getDivision(int a, int b) {
        return (double) a / (double) b;
    }

    static String getResultOfOperation(int a, int b, String signOperation) {
        switch (signOperation) {
        case "+":
            return String.format("%d %s %d = %d \n", a, signOperation, b, getSum(a, b));
        case "-":
            return String.format("%d %s %d = %d \n", a, signOperation, b, getSubtraction(a, b));
        case "*":
            return String.format("%d %s %d = %d \n", a, signOperation, b, getProduct(a, b));
        case "/":
            if (b != 0) {
                return String.format("%d %s %d = %.4f \n", a, signOperation, b, getDivision(a, b));
            } else {
                return String.format("Нельзя делить на 0 \n");
            }
        default:  return String.format("Неправильная операция \n");
        }
    }

    static void writeResultsToFile(String result){
        try (FileWriter fw = new FileWriter("file_home_work2_task3.txt", true)) {
            fw.write(result);
            fw.write("\n");
            fw.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
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
            String signOperation = "";
            if (sc.hasNextLine()) {
                signOperation = sc.nextLine();
            }
            if (signOperation.equals("+") || signOperation.equals("-") || signOperation.equals("*")
                    || signOperation.equals("/")) {
                int b = 0;
                System.out.printf("Введите второе число: ");
                if (!scn.hasNextInt()) {
                    System.out.println("Вы ввели неправильное число");
                } else {
                    b = scn.nextInt();                    
                    String result = getResultOfOperation(a, b, signOperation);
                    System.out.println(result);
                    writeResultsToFile(result);
                }
            } else {
                System.out.println("Вы ввели неправильный знак");
            }
            scn.close();
            sc.close();
        }
    }    
}
