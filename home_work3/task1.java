package Home_work_Java.home_work3;

import java.util.ArrayList;

public class task1 {
    static ArrayList<Integer> getListRandomNumbers(int n) {
        ArrayList<Integer> resultList = new ArrayList<Integer>();
        for (int i = 1; i < n; i++) {
             resultList.add((int)(Math.random()*((20) + 1)));
        }
        return resultList;
    }

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
    static ArrayList<Integer> mergeLists(ArrayList<Integer> list_1, ArrayList<Integer> list_2) {
        ArrayList<Integer> resultList = new ArrayList<Integer>();
        while (list_1.size() > 0 && list_2.size() > 0) {
            if (list_1.get(0) < list_2.get(0)) {
                resultList.add(list_1.get(0));
                list_1.remove(0);
            } else {
                resultList.add(list_2.get(0));
                list_2.remove(0); 
            }
        }
        if (list_1.size() > 0) {
            for (int i = 0; i < list_1.size(); i++) {
                   resultList.add(list_1.get(i));
            }
        }              
        if (list_2.size() > 0) {
            for (int i = 0; i < list_2.size(); i++) {
                   resultList.add(list_2.get(i));
            }
        }
        return resultList;
    }

    static ArrayList<Integer> mergeSortList(ArrayList<Integer> listNumbers) {
        int size = listNumbers.size();
        if (size < 2) {
            return listNumbers;
        }
        int middle = size / 2;
        ArrayList<Integer> leftList = new ArrayList<>();
        for (int i = 0; i < middle; i++) {
            leftList.add(listNumbers.get(0));
            listNumbers.remove(0);
     }
     return mergeLists(mergeSortList(leftList), mergeSortList(listNumbers));
    }   
    public static void main(String[] args) {
        int n = 20;
        ArrayList<Integer> listNumbers = getListRandomNumbers(n);
        System.out.printf("Случайный список из %d чисел (от 0 до 20) выглядит следующим образом: \n", n);
        printList(listNumbers);
        System.out.println("Это сортировка списка путем слияния:");
        printList(mergeSortList(listNumbers));
    }
}

