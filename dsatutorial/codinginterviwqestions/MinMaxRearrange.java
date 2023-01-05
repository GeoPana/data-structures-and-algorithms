package dsatutorial.codinginterviwqestions;

/*
Given sorted array of integers, rearrange array
in such a way that the first position will have
the largest number, the second will have the smallest,
the third will have the second-largest, and so on.
Using O(1) extra space.

Example –
 Input: arr = {1, 2, 3, 4, 5, 6, 7}
 Output: arr = {7, 1, 6, 2, 5, 3, 4}
 */

public class MinMaxRearrange {

    public static void minMaxRearrange(int[] arr) {
        int minIdx = 0;
        int maxIdx = arr.length - 1;
        int max = arr[maxIdx] + 1;
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                arr[i] = arr[i] + (arr[maxIdx] % max) * max;
                maxIdx--;
            } else {
                arr[i] = arr[i] + (arr[minIdx] % max) * max;
                minIdx++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] /= max;
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 6, 8, 9};
        printArray(arr);
        minMaxRearrange(arr);
        printArray(arr);
    }
}
