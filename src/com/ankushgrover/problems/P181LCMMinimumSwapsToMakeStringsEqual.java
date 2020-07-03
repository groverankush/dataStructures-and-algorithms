package com.ankushgrover.problems;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 03/07/20
 * <p>
 * https://leetcode.com/problems/minimum-swaps-to-make-strings-equal/
 * <p>
 * #medium
 */
public class P181LCMMinimumSwapsToMakeStringsEqual {

    public static void main(String[] args) {
        P181LCMMinimumSwapsToMakeStringsEqual obj = new P181LCMMinimumSwapsToMakeStringsEqual();
        System.out.println(obj.minimumSwap("xx", "yy"));
    }


    public int minimumSwap(String s1, String s2) {
        if (s1.length() != s2.length())
            return -1;

        if (s1.length() == 1 && s1.charAt(0) != s2.charAt(0))
            return -1;

        int x1[] = new int[2];
        int x2[] = new int[2];


        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                x1[s1.charAt(i) - 'x']++;
                x2[s2.charAt(i) - 'x']++;
            }
        }
        if (x1[0] != x2[1] || x1[1] != x2[0])
            return -1;

        int count = (x1[0] / 2) + (x1[1] / 2);
        x1[0] %= 2;
        x1[1] %= 2;
        x2[1] %= 2;
        x2[0] %= 2;
        return x1[0] != x1[1] ? -1 : count + (x1[0] * 2);
    }
}
