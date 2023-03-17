//Пусть дан LinkedList с несколькими элементами. Реализуйте метод(не void), 
//который вернет “перевернутый” список.

package Home_work_Java.home_work4;

import java.util.Arrays;
import java.util.LinkedList;

public class task1 {
    static LinkedList<Integer> reversList(LinkedList<Integer> listLinked) {
        LinkedList<Integer> listResult = new LinkedList<>();
        for (int element : listLinked) {
            listResult.addFirst(element);            
        }
        return listResult;
    }

    public static void main(String[] args) {
        LinkedList<Integer> listNumbers = new LinkedList<>(Arrays.asList(23, 13, 9, 7, 55, 42, 8, 12));
        System.out.println(listNumbers.toString());
        System.out.println(reversList(listNumbers).toString());
    }
}
