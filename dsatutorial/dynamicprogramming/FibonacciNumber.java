package dsatutorial.dynamicprogramming;

public class FibonacciNumber {

    // Bottom-Up Approach
//    public static int fib(int n) {
//        int[] table = new int[n + 1];
//        table[0] = 0;
//        table[1] = 1;
//        for (int i = 2; i <= n; i++)
//            table[i] = table[i - 1] + table[i - 2];
//        return table[n];
//    }

    // Top-Down Approach
    public static int fib(int n) {
        int[] memo = new int[n + 1];
        return fib(memo, n);
    }
    public static int fib(int[] memo, int n) {
        if (memo[n] == 0) {
            if (n < 2) {
                memo[n] = n;
            } else {
                int left = fib(memo, n - 1);
                int right = fib(memo, n - 2);
                memo[n] = left + right;
            }
        }
        return memo[n];
    }

    public static void main(String[] args) {
        System.out.println(fib(8));
    }
}
