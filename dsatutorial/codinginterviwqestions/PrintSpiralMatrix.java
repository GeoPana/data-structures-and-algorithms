package dsatutorial.codinginterviwqestions;

public class PrintSpiralMatrix {

    public static void printSpiralMatrix(int[][] matrix) {
        int r = matrix.length; // number of rows
        int c = matrix[0].length; //number of columns
        int k = 0; // stores row level
        int l = 0; // stores column level

        while (k < r && l < c) {
            for (int i = l; i < c; i++) {   // Left --> Right
                System.out.print(matrix[k][i] + " ");
            }
            k++;
            for (int i = k; i < r; i++) {   // Up --> Bottom
                System.out.print(matrix[i][c - 1] + " ");
            }
            c--;
            if (k < r) {
                for (int i = c - 1; i >= l; i--) {  // Right --> Left
                    System.out.print(matrix[r - 1][i] + " ");
                }
                r--;
            }
            if (l < c) {
                for (int i = r - 1; i >= k; i--) {  // Bottom --> Up
                    System.out.print(matrix[i][l] + " ");
                }
                l++;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
        };

        printSpiralMatrix(matrix);
    }
}
