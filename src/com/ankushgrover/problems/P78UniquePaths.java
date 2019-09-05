package com.ankushgrover.problems;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 05/09/19
 *
 * https://leetcode.com/problems/unique-paths/
 */
public class P78UniquePaths {

    public static void main(String[] args) {
        P78UniquePaths paths = new P78UniquePaths();
        int m = 56, n = 7;
        System.out.println(paths.uniquePathsV1(m, n));
        System.out.println(paths.uniquePathsV2(m, n));


    }

    public int uniquePathsV1(int m, int n) {


        int dp[][] = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][n - 1] = 1;
        }

        for (int i = 0; i < n; i++) {
            dp[m - 1][i] = 1;
        }

        for (int j = m - 2; j >= 0; j--) {
            for (int i = n - 2; i >= 0; i--) {
                dp[j][i] = dp[j + 1][i] + dp[j][i + 1];
            }
        }

        return dp[0][0];
    }

    public int uniquePathsV2(int m, int n) {

        if (m <= 1 || n <= 1)
            return 1;

        int[] dp = new int[n - 1];

        //Arrays.fill(dp, 1);


        for (int j = m - 2; j >= 0; j--) {
            for (int i = dp.length - 1; i >= 0; i--) {
                //int value = i == dp.length-1 ? 1 : dp[i] + j == m-2 ? 1 : dp[i-1];
                dp[i] = (i == dp.length - 1 ? 1 : dp[i + 1]) + (j == m - 2 ? 1 : dp[i]);
            }
        }

        return dp[0];
    }
}
