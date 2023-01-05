package dsatutorial.codinginterviwqestions;

/*
----------------- Two Sum I - LeetCode #1 -----------------
Given an array of integers numbers and an integer target,
return indices of the two numbers such that they add up
to target.
You may assume that each input would have exactly one
solution, and you may not use the same element twice.
You can return the answer in any order.
------------------------------------------------------------
 */
import java.util.HashMap;

public class TwoSumI {

    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (!map.containsKey(target - numbers[i])) {
                map.put(numbers[i], i);
            } else {
                result[1] = i;
                result[0] = map.get(target - numbers[i]);
                return result;
            }
        }
        throw new IllegalArgumentException("Two numbers not found. ");
    }

    public static void main(String[] args) {
        int[] numbers = {2, 11, 5, 10, 7, 8};
        int[] result = twoSum(numbers, 9);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }
}
