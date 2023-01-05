package dsatutorial.codinginterviwqestions;

/*
-------------------- Reverse Integer - LeetCode #7 --------------------
Given a signed 32-bit integer x, return x with its digits reversed. If
reversing x causes the value to go outside the signed 32-bit integer
range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers
(signed or unsigned).
-----------------------------------------------------------------------
 */

public class ReverseInteger { // TO DO: solve without using long data type

    public static long reverseInteger(int number) {
        boolean isNegative = number < 0;
        if (isNegative)
            number *= -1;
        int lastDigit;
        long reverse = 0;
        while (number > 0) { // terminates when number == 0
            lastDigit = number % 10;
            reverse = reverse * 10 + lastDigit;
            number = number / 10;
        }
        return isNegative ? (-1 * reverse) : reverse;
    }

    public static void main(String[] args) {
        System.out.println(reverseInteger(-4321));
    }
}
