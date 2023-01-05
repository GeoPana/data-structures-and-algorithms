package dsatutorial.codinginterviwqestions;

/*
----------- Product Of Array Except Self - LeetCode #238 -----------
Given an integer array numbers, return an array result such that
result[i] is equal to the product of all the elements of numbers
except numbers[i].

The product of any prefix or suffix of numbers is guaranteed to fit
in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without
using the division operation.
--------------------------------------------------------------------
 */

import java.util.HashMap;

public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] numbers) {
        int[] result = new int[numbers.length];
        int temp = 1;
        for (int i = 0; i < numbers.length; i++) {
            result[i] = temp;
            temp *= numbers[i];
        }
        temp = 1;
        for (int i = numbers.length - 1; i >= 0; i--) {
            result[i] *= temp;
            temp *= numbers[i];
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
        int[] numbers = {1, 2, 3, 4};
        int[] result = productExceptSelf(numbers);
        printArray(numbers);
        printArray(result);
    }
}
