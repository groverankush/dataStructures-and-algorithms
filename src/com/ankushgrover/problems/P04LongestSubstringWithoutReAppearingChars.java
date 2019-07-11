package com.ankushgrover.problems;

import java.util.HashSet;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class P04LongestSubstringWithoutReAppearingChars {

    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {

        int prev = 0;
        int cur = 0;
        HashSet<Character> set = new HashSet<>();
        int start = 0;
        int i = 0;
        while (i < s.length()) {

            Character ch = s.charAt(i);
            if (set.contains(ch)) {
                prev = cur > prev ? cur : prev;
                cur = 0;
                set.clear();
                start += 1;
                i = start;
            } else {
                cur++;
                set.add(ch);
                i++;
            }
        }

        return cur > prev ? cur : prev;

    }
}
