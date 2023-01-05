package dsatutorial.codinginterviwqestions;

public class MaximumSumSubarraySizeK {

    public static int maxSumSubarray(int[] arr, int k) {
        int maxSum = 0;
        int windowSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i < k) {
                windowSum += arr[i];
                maxSum = windowSum;
            } else {
                windowSum = windowSum - arr[i - k] + arr[i];
                maxSum = (windowSum > maxSum) ? windowSum : maxSum;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 3, 5, 8, 1};
        int maxSum = maxSumSubarray(arr, 3);
        System.out.println(maxSum);
    }
}
