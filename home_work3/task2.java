// Пусть дан произвольный список целых чисел, удалить из него чётные числа

package Home_work_Java.home_work3;

import java.util.ArrayList;
import java.util.Arrays;

public class task2 {
    static void printList(ArrayList<Integer> list) {
        int size = list.size();
        if (size == 1) {
            System.out.printf("[%d]",list.get(0));
        } else if (size > 1) {
            System.out.printf("[%d", list.get(0));
            for (int i = 1; i < size; i++) {
                System.out.printf(", %d", list.get(i));
            }
            System.out.println("]");
        }
    }

    static void removeEvenNumbersFromList(ArrayList<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> listNumbers = new ArrayList<>(Arrays.asList(5, 4, 1, 7, 28, 13, 9, 14, 2, 56, 11));
        printList(listNumbers);
        removeEvenNumbersFromList(listNumbers);
        printList(listNumbers);
    }
}
