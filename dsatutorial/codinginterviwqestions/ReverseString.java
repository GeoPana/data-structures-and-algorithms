package dsatutorial.codinginterviwqestions;

public class ReverseString {
    public static String reverse(String str) {
        char[] charArray = str.toCharArray();
        String newString = "";
        for (int i = charArray.length - 1; i >= 0; i--) {
            newString = newString + charArray[i];
        }
        return newString;
    }

    public static void main(String[] args) {
        String str = "abcd";
        System.out.println(reverse(str));
    }
}
