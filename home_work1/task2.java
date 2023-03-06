//Вывести все простые числа от 1 до 1000
package Home_work_Java.home_work1;

public class task2 {
    boolean is_simple(int n) {
        for (int index = 2; index < n; index++) {
            if (n % index == 0 )
                return false;
        }
        return true;

    }
    public static void main(String[] args) {
        task2 t = new task2();
        StringBuilder st = new StringBuilder();
        st = st.append("1");
        for (int i = 2; i < 1000; i++) {
            if (t.is_simple(i))
                st = st.append(", ").append(i);
        }
    System.out.println("Простые числа от 1 до 1000: ");   
    System.out.println(st);   
    }
}

