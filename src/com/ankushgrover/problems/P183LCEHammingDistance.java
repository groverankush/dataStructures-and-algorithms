package com.ankushgrover.problems;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 05/07/20
 * <p>
 * https://leetcode.com/problems/hamming-distance/
 * <p>
 * #easy
 */
public class P183LCEHammingDistance {

    public static void main(String[] args) {
    }

    public int hammingDistance(int x, int y) {

        return Integer.bitCount(x ^ y);
    }
}
