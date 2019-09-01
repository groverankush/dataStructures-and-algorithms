package com.ankushgrover.problems;

import java.util.HashMap;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 31/08/19
 */
public class P68IsomorphicString {

    public static void main(String[] args) {
    }

    public boolean isIsomorphic(String s, String t) {

        if(s == null && t == null)
            return true;

        if(s== null || t == null)
            return false;

        if(s.length()!=t.length())
            return false;


        HashMap<Character, Character> map = new HashMap<>();

        for(int i = 0 ; i < s.length(); i++){
            Character ch  = map.get(s.charAt(i));

            if(ch!=null && ch != t.charAt(i))
                return false;

            map.put(s.charAt(i), t.charAt(i));
        }

        return true;
    }
}
