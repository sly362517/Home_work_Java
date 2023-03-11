// Реализуйте алгоритм сортировки пузырьком числового массива (введён вами),
// результат после каждой итерации запишите в лог-файл.

package Home_work_Java.home_work2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class task1 {
    static String convertArrayToString(int []arr) {
        StringBuilder stb = new StringBuilder();
        for (int element : arr) {
            stb.append(element).append(" ");
        }
        return stb.toString();
    }

    static void sortByBubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            writeToFile(convertArrayToString(arr));
        }
    }

    static void writeToFile( String line) {
        try (FileWriter fw = new FileWriter("file_home_work2_task1.txt", true)) {
            fw.write(line);
            fw.write("\n");
            fw.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    static int[] convertFromStringToInt(String [] arr) {
        int [] arrayResult = new int [arr.length];
        for (int i = 0; i < arr.length; i++) {
            arrayResult[i] = Integer.parseInt(arr[i]);
        }
        return arrayResult;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.printf("Введите порядок чисел через запятую для создания массива: ");
        String numbers = scn.nextLine();
        numbers = numbers.replace(" ", "");
        String [] arrayNumbers = numbers.split(",");
        sortByBubble(convertFromStringToInt(arrayNumbers));
        scn.close();
    }
}

