package dsatutorial.codinginterviwqestions;

public class LongestPalindromicSubstring {
    public static int longestPalindrome(String str) {
        int max = 0;
        for (int i = 0; i < str.length(); i++) {
            max = Math.max(max, findLength(str, i, i));
            max = Math.max(max, findLength(str, i, i + 1));
        }
        return max;
    }

    private static int findLength(String str, int start, int end) {
        if (end >= str.length() || str.charAt(start) != str.charAt(end))
            return 0;
        int length = (start == end)  ? 1 : 2;
        start--;
        end++;
        while (start >= 0 && end < str.length() && str.charAt(start) == str.charAt(end)) {
            length = length + 2;
            start--;
            end++;
        }
        return length;
    }

    public static void main(String[] args) {
        String str = "ababab";
        System.out.println(longestPalindrome(str));
    }
}
