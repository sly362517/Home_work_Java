// На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.
// И вывести Доску.
// Пример вывода доски 8x8

// 0x000000
// 0000x000
// 00x00000
package Home_work_Java.home_work5;

public class task3 {
    public static int count = 0; 
    public static int n = 8; 

    public static void printPlacement(int[][] arr) {
      System.out.println(count + " " + "Вариант:");
      for (int i = 0; i < arr.length; i++) {
        for (int j = 0; j < arr[i].length; j++) {
          if (arr[i][j] == 1)
            System.out.print("X ");
          else
            System.out.print("0 ");
        }
        System.out.println("");
      }
      System.out.println("");
    }

    public static void placements(int row, int[][] arr) {
      if (row == n) {
        count++;
        printPlacement(arr); 
      } else {
        int[][] newArr = new int[n][n]; 
        for (int i = 0; i < arr.length; i++) {
          for (int j = 0; j < arr[i].length; j++) {
            newArr[i][j] = arr[i][j];
          }
        }
  
        for (int col = 0; col < n; col++) {
          if (isSafe(row, col, newArr)) { 
            for (int c = 0; c < n; c++) {
              newArr[row][c] = 0;   
            }
            newArr[row][col] = 1; 
            placements(row + 1, newArr); 
          }
        }
      }
    }
  
    public static boolean isSafe(int row, int col, int[][] newArr) {
      for (int r = row - 1; r >= 0; r--) {
        if (newArr[r][col] == 1) {
          return false;
        }
      }
      for (int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--) {
        if (newArr[r][c] == 1) {
          return false;
        }
      }
      for (int r = row - 1, c = col + 1; r >= 0 && c < n; r--, c++) {
        if (newArr[r][c] == 1) {
          return false;
        }
      }
      return true;
    }
  
    public static void main(String[] args) {
      int[][] arr = new int[n][n];
      placements(0, arr); 
    }
}
