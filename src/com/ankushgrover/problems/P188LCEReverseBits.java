package com.ankushgrover.problems;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 12/07/20
 */
public class P188LCEReverseBits {

    public static void main(String[] args) {
    }

    public int reverseBits(int n) {
        String bits = Integer.toBinaryString(n);
        int pow = 31;
        int total = 0;
        for (int i = bits.length() - 1; i >= 0; i--) {
            if (bits.charAt(i) == 1) {
                total += Math.pow(2, pow);
            }
            pow--;
        }
        return total;
    }
}
