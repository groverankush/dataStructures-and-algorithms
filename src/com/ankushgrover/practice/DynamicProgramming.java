package com.ankushgrover.practice;

import java.util.Arrays;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 26/09/19
 */
public class DynamicProgramming {

    public static void main(String[] args) {

        DynamicProgramming obj = new DynamicProgramming();

        int[] weights = {1, 3, 4, 5};
        int[] values = {1, 4, 5, 7};
        int weight = 7;
        //System.out.println(obj.knapSack01(weights, values, weight));


        String a = "abcfde";
        String b = "axbfe";
        System.out.println(obj.longestCommonSubsequence(a, b));
    }

    private int knapSack01(int[] weights, int[] values, int weight) {

        int[][] dp = new int[weights.length][weight + 1];

        int i = 0, j = 0;

        for (i = 0; i < weights.length; i++) {

            for (j = 1; j <= weight; j++) {

                if (weights[i] > j) {
                    dp[i][j] = helperGetPrev(i - 1, j, dp);
                } else
                    dp[i][j] = Math.max(values[i] + helperGetPrev(i - 1, j - weights[i], dp), helperGetPrev(i - 1, j, dp));

            }

        }

        helperPrint(dp);

        return dp[i - 1][j - 1];

    }

    private int longestCommonSubsequence(String a, String b) {

        int[][] dp = new int[a.length()][b.length()];

        int i, j = 0;
        for (i = 0; i < a.length(); i++) {
            for (j = 0; j < b.length(); j++) {

                dp[i][j] = (a.charAt(i) == b.charAt(j) ? (1 + helperGetPrev(i - 1, j - 1, dp)) : (Math.max(helperGetPrev(i - 1, j, dp), helperGetPrev(i, j - 1, dp))));

            }
        }

        return dp[i - 1][j - 1];
    }

    private void helperPrint(int[][] dp) {
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
    }

    private int helperGetPrev(int i, int j, int[][] dp) {
        return i < 0 || j < 0 || i >= dp.length || j >= dp[0].length ? 0 : dp[i][j];
    }
}
