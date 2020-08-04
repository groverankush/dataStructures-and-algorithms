package com.ankushgrover.problems;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 04/08/20
 * <p>
 * https://leetcode.com/problems/power-of-four/
 * <p>
 * #easy
 */
public class P205LCEPowerOfFour {

    public static void main(String[] args) {
    }

    public boolean isPowerOfFour(int num) {

        if (num <= 0)
            return false;

        while (num > 1) {

            int val = num % 4;
            if (val > 0)
                return false;
            num = num / 4;

        }

        return true;
    }
}
