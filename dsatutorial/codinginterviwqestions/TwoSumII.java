package dsatutorial.codinginterviwqestions;

import java.util.Arrays;

/*
----------------- Two Sum I - LeetCode #167 -----------------

-------------------------------------------------------------
 */
public class TwoSumII {

    public static int[] twoSum(int[] numbers, int target) { // numbers must be sorted
        Arrays.sort(numbers); // make sure numbers is sorted
        int[] result = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                result[0] = numbers[left];
                result[1] = numbers[right];
                return result;
            } else if (numbers[left] + numbers[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        throw new IllegalArgumentException("No possible sum can reach the provided target. ");
    }

    public static void main(String[] args) {
        int[] numbers = {2, 11, 5, 10, 7, 8};
        int[] result = twoSum(numbers, 9);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }
}
