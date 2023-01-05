package dsatutorial.algorithms.sort;

public class InsertionSort {

    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) { // unsorted part
            int temp = arr[i];
            int j = i - 1;  // sorted part
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j]; //shifting larger elements to temp by 1 position
                j -= 1;
            }
            arr[j + 1] = temp;
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {11, 4, 1, 7, 6, 10, 3};
        printArray(arr);
        sort(arr);
        printArray(arr);
    }
}
