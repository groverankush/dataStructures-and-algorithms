package com.ankushgrover.problems;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 03/09/19
 * <p>
 * https://leetcode.com/problems/longest-palindromic-substring/
 */
public class P73LongestPalindromeSubstring {

    public static void main(String[] args) {

        System.out.println(longestPalindrome("ababababaskjdabsndkjbabbabbbbbbbbbbbbababababbbbbbabbba"));
    }

    private static String longestPalindrome(String s) {

        if (s == null || s.length() < 1) return "";

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandMiddle(s, i, i);
            int len2 = expandMiddle(s, i, i + 1);

            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }


        }

        return s.substring(start, end + 1);


    }

    private static int expandMiddle(String s, int start, int end) {

        int l = start, r = end;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }

        return r - l - 1;

    }
}
