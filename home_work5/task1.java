package Home_work_Java.home_work5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class task1 {
    public static void addPhone(Map<String, ArrayList<Integer>> phoneBook) {
        System.out.println("Введите фамилию: ");
        Scanner iScanner = new Scanner(System.in, "Cp866");
        String surname = iScanner.nextLine();
        System.out.println("Введите номер телефона: ");
        if (phoneBook.containsKey(surname)) {
            phoneBook.get(surname).add(Integer.parseInt(iScanner.nextLine()));
        } else {
            ArrayList<Integer> phones = new ArrayList<>();
            phones.add(Integer.parseInt(iScanner.nextLine()));
            phoneBook.put(surname, phones);
        }
    }

    public static void printAll(Map<String, ArrayList<Integer>> phoneBook) {
        for (var item : phoneBook.entrySet()) {
            System.out.printf("\n"+item.getKey() + ": ");
            for (int element : item.getValue()) {
                System.out.printf(Integer.toString(element) + ", ");
            }
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        System.out.println("Для добавления номера - нажмите 1, для вывода всего списка - нажмите 2\nВведите stop чтобы выйти из Телеонного справочника");
        Scanner iScanner = new Scanner(System.in);
        Map<String, ArrayList<Integer>> phoneBook = new HashMap<>();
        String answer = iScanner.nextLine();
        while (!answer.equals("stop")) {
            if (Integer.parseInt(answer) == 1)
                addPhone(phoneBook);
            if (Integer.parseInt(answer) == 2)
                printAll(phoneBook);
            System.out.println("Для добавления номера - нажмите 1, для вывода всего списка - нажмите 2\nВведите stop чтобы выйти из Телеонного справочника");
            answer = iScanner.nextLine();
        }
        iScanner.close();
    }
}
