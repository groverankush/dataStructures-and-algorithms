package com.ankushgrover.problems;

import java.util.HashMap;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 09/09/19
 */
public class P87IsomorphicStrings {

    public static void main(String[] args) {
        String s = "foo";
        String t = "bar";
        System.out.println(isIsomorphic(s, t));
    }

    private static boolean isIsomorphic(String s, String t) {

        if (s == null && t == null)
            return true;

        if (s == null || t == null)
            return false;

        if (s.length() != t.length())
            return false;


        HashMap<Character, Character> map = new HashMap<>();


        for (int i = 0; i < s.length(); i++) {
            Character ch = map.get(s.charAt(i));


            if (ch != null && ch != t.charAt(i))
                return false;


            map.put(s.charAt(i), t.charAt(i));
        }

        map.clear();

        for (int i = 0; i < t.length(); i++) {
            Character ch = map.get(t.charAt(i));


            if (ch != null && ch != s.charAt(i))
                return false;


            map.put(t.charAt(i), s.charAt(i));
        }


        return true;

    }
}
