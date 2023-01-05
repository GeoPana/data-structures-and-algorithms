package dsatutorial.codinginterviwqestions;

public class PalindromicSubstrings {
    public static int countPalindromes(String str) {
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            result += count(str, i, i) + count(str, i, i + 1);
        }
        return result;
    }

    private static int count(String str, int start, int end) {
        int count = 0;
        while (start >= 0 && end < str.length() && str.charAt(start) == str.charAt(end)) {
            count++;
            start--;
            end++;
        }
        return count;
    }

    public static void main(String[] args) {
        String str = "aaaa";
        System.out.println(countPalindromes(str));
    }
}
