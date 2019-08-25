package com.ankushgrover.problems;

import java.util.HashMap;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 25/08/19
 * <p>
 * https://leetcode.com/problems/roman-to-integer/
 */
public class P53RomanToInt {

    public static void main(String[] args) {
        System.out.println(romanToInt("XV"));
    }

    private static int romanToInt(String s) {

        if (s == null || s.isEmpty())
            return 0;

        HashMap<Character, Integer> map = makeMap();

        int num = map.get(s.charAt(s.length() - 1));

        for (int i = s.length() - 2; i >= 0; i--) {
            if (isDecreasing(s.charAt(i), s.charAt(i + 1), map)) {
                num = num - map.get(s.charAt(i));
            } else
                num = num + map.get(s.charAt(i));
        }

        return num;

    }

    private static HashMap<Character, Integer> makeMap() {

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        return map;

    }

    private static boolean isDecreasing(char current, char next, HashMap<Character, Integer> map) {

        return map.get(current) < map.get(next);

    }


}
