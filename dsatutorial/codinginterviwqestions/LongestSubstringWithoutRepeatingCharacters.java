package dsatutorial.codinginterviwqestions;

/*
------ Longest Substring Without Repeating Characters - LeetCode #3 ------
Given a string s, find the length of the longest substring without
repeating characters.
--------------------------------------------------------------------------
 */

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c) + 1);
            }
            map.put(c, end);
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String str = "abcabcbb";
        int maxLength = lengthOfLongestSubstring(str);
        System.out.println(maxLength);
    }
}
