package com.ankushgrover.problems;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 10/08/20
 * <p>
 * https://leetcode.com/problems/excel-sheet-column-number/
 * <p>
 * #easy
 */
public class P207LCEExcelColoumnNumber {

    public static void main(String[] args) {
    }

    public int titleToNumber(String s) {

        int res = 0;
        for (int i = 0; i < s.length(); i++) {

            res = res + ((int) ((s.charAt(i) - 'A' + 1) * Math.pow(26, s.length() - 1 - i)));

        }
        return res;

    }
}
