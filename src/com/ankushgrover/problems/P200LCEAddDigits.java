package com.ankushgrover.problems;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 27/07/20
 * <p>
 * https://leetcode.com/problems/add-digits/
 * <p>
 * #easy
 */
public class P200LCEAddDigits {

    public static void main(String[] args) {
    }

    public int addDigits(int num) {
        return num == 0 ? 0 : num % 9 == 0 ? 9 : (num % 9);
    }
}
