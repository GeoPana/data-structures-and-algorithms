package dsatutorial.codinginterviwqestions;

/*
-------------------- 3Sum - LeetCode #15 ------------------------------
Given an integer array numbers, return all the triplets
[numbers[i], numbers[j], numbers[k]] such that i != j, i != k,
and j != k, and numbers[i] + numbers[j] + numbers[k] == target,
where target is a specified input.

Notice that the solution set must not contain duplicate
triplets.
-----------------------------------------------------------------------
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] numbers, int target) {
        Arrays.sort(numbers);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numbers.length - 2; i++) {
            int j = i + 1;
            int k = numbers.length - 1;
            while (j < k) {
                int sum = numbers[i] + numbers[j] + numbers[k];
                if (sum == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(numbers[i]);
                    list.add(numbers[j]);
                    list.add(numbers[k]);
                    if (!result.contains(list))
                        result.add(list);
                    j++;
                    k--;
                } else if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 4, 3, 7, 1, 8, 9, 0};
        List<List<Integer>> triplets = threeSum(numbers, 6);
        System.out.println(triplets.toString());
    }
}
