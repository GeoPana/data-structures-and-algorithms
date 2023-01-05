package dsatutorial.codinginterviwqestions;

/*
------------ Sliding Window Maximum - Leetcode #239 --------------
You are given an array of integers numbers, there is a sliding
window of size k which is moving from the very left of the array
to the very right. You can only see the k numbers in the window.
Each time the sliding window moves right by one position.

Return the max sliding window.
------------------------------------------------------------------
 */

import java.util.Arrays;

public class MaxSlidingWindow {

    public static int[] maxSlidingWindow(int[] numbers, int k) { // window's size
        if (k > numbers.length)
            throw new IllegalArgumentException("Window cannot be larger than the array. ");
        int[] result = new int[numbers.length - k + 1];
        int start = 0;
        int end = k - 1;
        int max = numbers[start];
        for (int i = start + 1; i <= end; i++) {
            if (numbers[i] > max)
                max = numbers[i];
        }
        int j = 0; // traverse result
        result[j] = max;
        end++;
        j++;
        while (end < numbers.length) {
            if (numbers[end] > max)
                max = numbers[end];
            result[j] = max;
            end++;
            j++;
        }
        return result;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] numbers = {44, 77, 33, 44, 88, 11};
        int[] result = maxSlidingWindow(numbers, 3);
        printArray(numbers);
        printArray(result);
    }
}
