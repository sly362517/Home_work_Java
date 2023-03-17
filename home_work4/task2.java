// Реализуйте очередь с помощью LinkedList со следующими методами:
// enqueue() - помещает элемент в конец очереди, 
// dequeue() - возвращает первый элемент из очереди и удаляет его, 
// first() - возвращает первый элемент из очереди, не удаляя.

package Home_work_Java.home_work4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class task2 {
    static void enqueueElement(LinkedList<String> listLinked, String element) {
        listLinked.addLast(element);
    }

    static String dequeueElement(LinkedList<String> listLinked) {
        String result = null;
        if (listLinked.size() > 0) {
            result = listLinked.get(0);
            listLinked.remove(0);
        }
        return result;
    }

    static String getFirstElement(LinkedList<String> listLinked) {
        String result = null;
        if (listLinked.size() > 0) {
            result = listLinked.get(0);
        }
        return result;
    }

    public static void main(String[] args) {
        LinkedList<String> listLinked= new LinkedList<>(
                Arrays.asList("42", "fdd", "324", "dre4", "ff", "asv", "4", "d24"));
        System.out.println(listLinked.toString());
        Scanner scn = new Scanner(System.in);
        System.out.println("Для добавления элемента в конец списка введите: 1 ");
        System.out.println("Для удаления первого элемента введите: 2 ");
        System.out.println("Для получения первого элемента введите: 3 ");

        while (scn.hasNextLine()) {
            String numberOperationString = scn.nextLine();
            int numberOperation = Integer.parseInt(numberOperationString);
            if (numberOperation == 1) {
                System.out.print("Введите элемент для добавления: ");
                //Scanner scn_str = new Scanner(System.in);
                String element = scn.nextLine();
                //scn_str.close();
                enqueueElement(listLinked, element);
                System.out.println("Список после добавления элемента: ");
                System.out.println(listLinked.toString());
            } else if (numberOperation == 2){
                System.out.printf("Из списка удалили следующий первый элемент: %s \n", dequeueElement(listLinked));
                System.out.println("Список после удаления элемента: ");
                System.out.println(listLinked.toString());
            } else if (numberOperation == 3){
                System.out.printf("Первый элемент списка следующий: %s \n", getFirstElement(listLinked));
            } else {
                System.out.println("Ввели некорректный номер операции!!!");
            }
        }
        scn.close();        
    }
}
