package com.ankushgrover.problems;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 02/07/20
 * #easy
 */
public class P178LCEArrangingCoins {

    public static void main(String[] args) {
    }

    public int arrangeCoins(int n) {
        int target = 1;
        int count = 0;
        while (n >= target) {
            n -= target;
            target++;
            count++;
        }
        return count;
    }
}
