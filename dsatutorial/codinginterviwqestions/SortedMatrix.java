package dsatutorial.codinginterviwqestions;

public class SortedMatrix {

    public static void search(int[][] matrix, int n, int x) {
        int i = 0;
        int j = n - 1;
        while (i < n && j >= 0) {
            if (matrix[i][j] == x) {
                System.out.println("Element " + x +
                        " is found at point [" + i + ", " + j + "]. ");
                return;
            }
            if (matrix[i][j] < x) {
                i++;
            }else  {
                j--;
            }
        }
        System.out.println("Element " + x + " not found. ");
    }

    public static void main(String[] args) {
        int[][] matrix = {
                          {10, 20, 30, 40},
                          {15, 25, 35, 45},
                          {27, 29, 37, 48},
                          {32, 33, 39, 51}
                         };
        search(matrix, matrix[0].length, 37);
    }

}
