package com.ankushgrover.problems;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 09/06/20
 * <p>
 * #easy
 * https://leetcode.com/problems/is-subsequence/
 */
public class P168LCEIsSubsequence {

    public static void main(String[] args) {
    }

    public boolean isSubsequence(String s, String t) {

        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {

            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }

        }

        return i == s.length();

    }
}
