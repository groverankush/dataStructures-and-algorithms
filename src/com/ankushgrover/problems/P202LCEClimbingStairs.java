package com.ankushgrover.problems;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 01/08/20
 * <p>
 * https://leetcode.com/problems/climbing-stairs/
 * <p>
 * #easy #fibinacci
 */
public class P202LCEClimbingStairs {

    public static void main(String[] args) {
    }

    public int climbStairs(int n) {
        int first = 0;
        int sec = 1;

        for (int i = 0; i < n; i++) {
            int sum = first + sec;
            first = sec;
            sec = sum;
        }

        return sec;
    }
}
