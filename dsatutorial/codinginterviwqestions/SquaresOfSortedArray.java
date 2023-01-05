package dsatutorial.codinginterviwqestions;

public class SquaresOfSortedArray {

    public static int[] squaresOfSortedArray(int arr[]) {
        int[] result = new int[arr.length];
        int front = 0;
        int end = arr.length - 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (Math.abs(arr[front]) > Math.abs(arr[end])) {
                result[i] = arr[front] * arr[front];
                front++;
            } else {
                result[i] = arr[end] * arr[end];
                end--;
            }
        }
        return result;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {-4, -1, 0, 3, 10};
        printArray(arr);
        int[] result = squaresOfSortedArray(arr);
        printArray(result);
    }
}
