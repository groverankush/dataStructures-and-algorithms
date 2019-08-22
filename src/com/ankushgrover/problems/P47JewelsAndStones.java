package com.ankushgrover.problems;

import java.util.HashSet;

/**
 * https://leetcode.com/problems/jewels-and-stones/
 */
public class P47JewelsAndStones {

    public static void main(String[] args) {
        String j = "as", s = "aaSSss";
        System.out.println(numJewelsInStones(j, s));

    }

    private static int numJewelsInStones(String J, String S) {

        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < J.length(); i++) {
            set.add(J.charAt(i));
        }

        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            if (set.contains(S.charAt(i)))
                count++;
        }

        return count;
    }
}
