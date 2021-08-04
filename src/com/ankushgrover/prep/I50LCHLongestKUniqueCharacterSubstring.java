package com.ankushgrover.prep;

import java.util.HashMap;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 07/07/21
 */
public class I50LCHLongestKUniqueCharacterSubstring {

    public static void main(String[] args) {
        I50LCHLongestKUniqueCharacterSubstring obj = new I50LCHLongestKUniqueCharacterSubstring();
        String s = "meayl";
        int k = 2;

        /*String s = "aabacbebebe";
        int k = 3;*/
        System.out.println(obj.longestkSubstr(s, k));
    }

    public int longestkSubstr(String s, int k) {
        return approach1(s, k);
    }

    private int approach1(String s, int k) {

        HashMap<Character, Integer> map = new HashMap<>();

        int start = 0;
        int end = 0;
        int res = -1;

        while (start < s.length()) {


            int size = map.size();

            if (size == k) {
                //int length = end == s.length() ? end - start : end - start + 1;
                int length = end - start;
                res = Math.max(res, length);
            }

            if (size <= k && end < s.length()) {
                char ch = s.charAt(end);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                end++;
            } else {
                char ch = s.charAt(start);
                int count = map.get(ch);
                if (count == 1)
                    map.remove(ch);
                else
                    map.put(ch, count - 1);
                start++;
            }

        }

        return res;

    }
}
