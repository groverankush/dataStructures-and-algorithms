package com.ankushgrover.prep;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 20/04/21
 *
 * https://www.hackerrank.com/challenges/pangrams/problem
 */
public class I8LCEPangrams {

    public static void main(String[] args) {

    }

    String pangrams(String s) {

        int arr[] = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isAlphabetic(ch)) {
                arr[Character.toLowerCase(ch) - 'a']++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0)
                return "not pangram";
        }

        return "pangram";

    }
}
