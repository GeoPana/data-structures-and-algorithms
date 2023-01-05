package dsatutorial.codinginterviwqestions;

/*
----------------- Is Subsequence - LeetCode #392 ---------------------
Given two strings s and t, return true if s is a subsequence of t,
or false otherwise.
A subsequence of a string is a new string that is formed from the
original string by deleting some (can be none) of the characters
without disturbing the relative positions of the remaining characters.
 (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
-----------------------------------------------------------------------
 */

public class IsSubsequence {

    public static boolean isSubsequence(String t, String s) {
        int i = 0; // traverse t
        int j = 0; // traverse s
        while (i < t.length() && j < s.length()){
            if (s.charAt(j) == t.charAt(i))
                j++;
            i++;
        }
        return j == s.length();
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("ahbgdc", "abc")); //true
        System.out.println(isSubsequence("ahbgdc", "axc"));  //false
    }
}
