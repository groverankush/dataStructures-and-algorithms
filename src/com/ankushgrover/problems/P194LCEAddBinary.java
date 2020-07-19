package com.ankushgrover.problems;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 19/07/20
 * <p>
 * https://leetcode.com/problems/add-binary/
 * <p>
 * #easy
 */
public class P194LCEAddBinary {

    public static void main(String[] args) {
    }

    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        StringBuilder builder = new StringBuilder();

        while (i >= 0 || j >= 0) {
            int ai = 0;
            int bi = 0;

            if (i >= 0) {
                ai = a.charAt(i) == '0' ? 0 : 1;
            }
            if (j >= 0) {
                bi = b.charAt(j) == '0' ? 0 : 1;
            }
            int sum = ai + bi + carry;

            if (sum == 0) {
                builder.insert(0, 0);
                carry = 0;
            } else if (sum == 1) {
                builder.insert(0, 1);
                carry = 0;
            } else if (sum == 2) {
                builder.insert(0, 0);
                carry = 1;
            } else {
                builder.insert(0, 1);
                carry = 1;
            }
            i--;
            j--;
        }

        if (carry == 1)
            builder.insert(0, 1);

        return builder.toString();

    }
}
