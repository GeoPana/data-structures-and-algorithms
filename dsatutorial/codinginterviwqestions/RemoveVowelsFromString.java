package dsatutorial.codinginterviwqestions;

/*
------- Remove Vowels From a String - LeetCode #387 --------------

------------------------------------------------------------------
 */

import java.util.Set;

public class RemoveVowelsFromString {

    public static String removeVowels(String str) { // only lower case
        Set<Character> vowels = Set.of('a', 'e', 'o', 'i', 'u');
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (Character c : chars ) {
            if (!vowels.contains(c))
                sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeVowels("ice cream"));
    }
}
