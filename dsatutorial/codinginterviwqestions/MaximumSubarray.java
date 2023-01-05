package dsatutorial.codinginterviwqestions;

/*
------------------ LeetCode #53 ------------------
Given an integer array num, find the contiguous
subarray (containing at least one number) which
has the largest sum and return its sum.

A subarray is a contiguous part of an array.
--------------------------------------------------
 */

public class MaximumSubarray {
    // Dynamic Programming Problem
    public static int maximumSubarray(int[] num){
        int currentMax = num[0];
        int largestSum = num[0];
        for (int i = 1; i < num.length; i++) {
            currentMax = currentMax + num[i];
            if (currentMax < num[i]) {
                currentMax = num[i];
            }
            if (currentMax > largestSum)
                largestSum = currentMax;
        }
        return largestSum;
    }

    public static void main(String[] args) {
        int[] num = {4, 3, -2, 6, -12, 7, -1, 6};
        System.out.println("Maximum Subarray Sum :" + maximumSubarray(num));
    }
}
