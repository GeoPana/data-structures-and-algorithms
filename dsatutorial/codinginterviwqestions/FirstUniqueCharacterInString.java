package dsatutorial.codinginterviwqestions;

/*
------- First Unique Character in a String - LeetCode #387 -------
Given a string s, find the first non-repeating character in it
and return its index. If it does not exist, return -1.
------------------------------------------------------------------
 */

import java.util.HashMap;

public class FirstUniqueCharacterInString {

    public static int firstUniqueCharacter(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++)
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

        for (int i = 0; i < s.length(); i++)
            if (map.get(s.charAt(i)) == 1)
                return i;

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqueCharacter("racecars"));
        System.out.println(firstUniqueCharacter("abba"));
    }
}
