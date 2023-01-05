package dsatutorial.datastructures.string;

import java.util.Stack;

public class StringUtil {

    public static boolean isPalindrome(String str) {
        //char[] charArray = str.toCharArray();
        for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j))
                return false;
        }
        return true;
    }

    public static String reverse(String str) {
        char[] charArr = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : charArr) {
            stack.push(c);
        }
        for (int i = 0; i < charArr.length; i++) {
            charArr[i] = stack.pop();
        }

        return new String(charArr);
    }

    public static void main(String[] args) {

        String str = "abba";
        System.out.println(str);
        System.out.println("Is Palindrome: " + isPalindrome(str));

        String string = "ABCD";
        System.out.println(string);
        String reversedString = reverse(string);
        System.out.println(reversedString);

    }

}
