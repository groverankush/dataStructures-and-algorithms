package com.ankushgrover.problems;

import java.util.LinkedList;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 06/07/20
 * <p>
 * https://leetcode.com/problems/plus-one/
 * <p>
 * #easy
 */
public class P184LCEPlusOne {

    public static void main(String[] args) {
    }

    public int[] plusOne(int[] digits) {
        LinkedList<Integer> list = new LinkedList<Integer>();

        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int digit;
            if (carry == 1 && digits[i] == 9) {
                digit = 0;
                carry = 1;
            } else {
                digit = carry + digits[i];
                carry = 0;
            }
            list.addFirst(digit);
        }
        if (carry != 0)
            list.addFirst(carry);

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
