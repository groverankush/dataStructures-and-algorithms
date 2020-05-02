package com.ankushgrover.problems;

import java.util.HashMap;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 02/05/20
 * <p>
 * https://leetcode.com/problems/jewels-and-stones
 */
public class P139LCJewelsAndStones {

    public static void main(String[] args) {
        P139LCJewelsAndStones obj = new P139LCJewelsAndStones();
        System.out.println(obj.numJewelsInStones("z", "ZZ"));
    }

    public int numJewelsInStones(String J, String S) {
        HashMap<Character, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < S.length(); i++) {
            int value = map.getOrDefault(S.charAt(i), 0);
            map.put(S.charAt(i), ++value);
        }

        for (int i = 0; i < J.length(); i++) {
            count += map.getOrDefault(J.charAt(i), 0);
        }

        return count;
    }
}
