package com.ankushgrover.problems;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 18/05/20
 * <p>
 * https://leetcode.com/problems/permutation-in-string/
 */
public class P154LCPermutationInString {

    public static void main(String[] args) {
    }

    public boolean checkInclusion(String p, String s) {

        int length = p.length();
        int pattern[] = makeArray(p, 0, length);

        for (int i = 0; i < s.length() - length + 1; i++) {
            if (isAnagram(s, i, length, pattern)) {
                return true;
            }
        }

        return false;

    }


    private boolean isAnagram(String s, int start, int length, int[] pattern) {
        int[] arr = makeArray(s, start, start + length);
        for (int i = 0; i < 26; i++) {
            if (arr[i] != pattern[i])
                return false;
        }
        return true;


    }

    private int[] makeArray(String s, int start, int end) {
        int arr[] = new int[26];
        for (int i = start; i < end; i++) {
            char ch = s.charAt(i);
            arr[ch - 'a'] = arr[ch - 'a'] + 1;
        }

        return arr;
    }
}
