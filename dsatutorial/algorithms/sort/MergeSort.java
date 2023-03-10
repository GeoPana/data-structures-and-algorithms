package dsatutorial.algorithms.sort;

public class MergeSort {

    public static void sort(int[] arr) {
        sort(arr, new int[arr.length], 0, arr.length - 1);
    }

    public static void sort(int[] arr, int[] temp, int low, int high) {
        if (low <high) {
            int mid = low + (high - low) / 2;
            sort(arr, temp, low, mid);
            sort(arr, temp, mid + 1, high);
            merge(arr, temp, low, mid, high);
        }
    }

    public static void merge(int[] arr, int[] temp, int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            temp[i] = arr[i];
        }
        int i = low;        // traverse left sorted subarray
        int j = mid + 1;    // traverse right sorted subarray
        int k = low;        // traverse sorting original array
        while (i <= mid && j <= high) {
            if (temp[i] <= temp[j]) {
                arr[k] = temp[i];
                i++;
            }else {
                arr[k] = temp[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            arr[k] = temp[i];
            i++;
            k++;
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
