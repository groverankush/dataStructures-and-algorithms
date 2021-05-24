package com.ankushgrover.prep.dp;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 15/05/21
 */
public class P2GridTraveller {

    public static void main(String[] args) {
        P2GridTraveller obj = new P2GridTraveller();
        int x = 2;
        int y = 5;
        long[][] dp = new long[x + 1][y + 1];
        System.out.println("Memoization: " + obj.waysDP(x, y, dp));
        System.out.println("Tabulation: " + obj.waysTabulation(x, y));
        System.out.println("Recursion: " + obj.waysNormal(x, y));

    }

    long waysNormal(long x, long y) {

        if (x < 1 || y < 1) {
            return 0;
        }

        if (x == 1 && y == 1) {
            return 1;
        }

        return waysNormal(x - 1, y) + waysNormal(x, y - 1);
    }

    long waysDP(int x, int y, long[][] dp) {

        if (x < 1 || y < 1) {
            return 0;
        }

        if (dp[x][y] != 0)
            return dp[x][y];

        if (x == 1 && y == 1) {
            return 1;
        }

        long downWays = waysDP(x - 1, y, dp);
        long rightWays = waysDP(x, y - 1, dp);
        dp[x][y] = downWays + rightWays;
        return dp[x][y];
    }

    long waysTabulation(int x, int y) {

        long[][] dp = new long[x + 1][y + 1];

        if (dp.length > 1 && dp[0].length > 1)
            dp[1][1] = 1;

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {

                if (j + 1 < dp[0].length)
                    dp[i][j + 1] += dp[i][j];
                if (i + 1 < dp.length)
                    dp[i + 1][j] += dp[i][j];

            }
        }

        return dp[x][y];

    }
}
