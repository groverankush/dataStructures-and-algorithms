package com.ankushgrover.problems;

import java.util.HashMap;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 03/05/20
 * <p>
 * https://leetcode.com/problems/ransom-note
 */
public class P142LCRansomNote {

    public static void main(String[] args) {
        P142LCRansomNote obj = new P142LCRansomNote();
        obj.canConstruct("aa", "aab");
    }

    public boolean canConstruct(String ransomNote, String magazine) {

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {
            int value = map.getOrDefault(magazine.charAt(i), 0);
            map.put(magazine.charAt(i), ++value);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            int value = map.getOrDefault(ransomNote.charAt(i), -1);
            if (value <= 0)
                return false;
            map.put(ransomNote.charAt(i), --value);
        }
        return true;
    }

}
