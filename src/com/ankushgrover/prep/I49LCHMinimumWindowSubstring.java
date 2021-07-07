package com.ankushgrover.prep;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 07/07/21
 */
public class I49LCHMinimumWindowSubstring {

    public static void main(String[] args) {

        I49LCHMinimumWindowSubstring obj = new I49LCHMinimumWindowSubstring();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(obj.minWindow(s, t));

    }

    public String minWindow(String s, String t) {
        return slidingWindowApproach(s, t);
    }

    private String slidingWindowApproach(String s, String t) {

        if (s.length() < t.length())
            return "";

        int start = 0;
        int end = 0;

        int starti = 0;
        int endi = Integer.MAX_VALUE - 2;

        int[] smap = new int[26 * 2];
        int[] tmap = new int[26 * 2];

        fillMap(tmap, t);

        while (start <= s.length() - t.length()) {


            if (contains(smap, tmap)) {
                if (end - start + 1 < endi - starti + 1) {
                    starti = start;
                    endi = end;
                }

                do {
                    smap[getIndex(s.charAt(start))]--;
                    start++;
                } while (tmap[getIndex(s.charAt(start))] == 0);

            } else {

                if (end < s.length()) {
                    smap[getIndex(s.charAt(end))]++;
                    end++;
                } else {
                    smap[getIndex(s.charAt(start))]--;
                    start++;
                }

            }


        }

        return s.substring(starti, endi);

    }

    private boolean contains(int smap[], int[] tmap) {
        for (int i = 0; i < smap.length; i++) {
            if (smap[i] < tmap[i])
                return false;
        }
        return true;
    }

    private void fillMap(int[] map, String s) {

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            map[getIndex(ch)]++;

        }
    }

    private int getIndex(char ch) {
        return ch <= 'Z' ? ch - 'A' : 26 + ch - 'a';
    }
}
