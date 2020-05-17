package com.ankushgrover.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 17/05/20
 */
public class P153LCFindAllAnagramsInAString {

    public static void main(String[] args) {
    }


    public List<Integer> findAnagrams(String s, String p) {

        int length = p.length();
        int pattern[] = makeArray(p, 0, length);
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < s.length() - length + 1; i++) {
            if (isAnagram(s, i, length, pattern)) {
                list.add(i);
            }
        }

        return list;


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
