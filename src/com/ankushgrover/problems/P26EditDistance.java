package com.ankushgrover.problems;

/**
 * Given two strings, determine the edit distance between them. The edit distance is defined as the minimum number of
 * edits (insertion, deletion, or substitution) needed to change one string to the other.
 * <p>
 * For example, "biting" and "sitting" have an edit distance of 2 (substitute b for s, and insert a t).
 */
public class P26EditDistance {

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "acb";

        long time = System.nanoTime();
        System.out.println(distance(s1, s2, s1.length(), s2.length()));
        System.out.println("Time: " + (System.nanoTime() - time));

        time = System.nanoTime();
        System.out.println(distanceDp(s1, s2, s1.length(), s2.length()));
        System.out.println("Time: " + (System.nanoTime() - time));
    }

    private static int min(int x, int y, int z) {
        if (x < y && x < z) return x;
        if (y < x && y < z) return y;
        return z;
    }


    private static int distanceDp(String str1, String str2, int m, int n) {

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0)
                    dp[i][j] = j;

                else if (j == 0)
                    dp[i][j] = i;

                else if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + min(dp[i - 1][j - 1], dp[i][j - 1], dp[i - 1][j]);
            }
        }

        return dp[m][n];

    }

    /**
     * Complexity O(3^n) exponential
     *
     * @param str1
     * @param str2
     * @param m
     * @param n
     * @return
     */
    private static int distance(String str1, String str2, int m, int n) {

        if (m == 0)
            return n;

        if (n == 0)
            return m;

        if (str1.charAt(m - 1) == str2.charAt(n - 1))
            return distance(str1, str2, m - 1, n - 1);

        return 1 + min(distance(str1, str2, m, n - 1), //insert
                distance(str1, str2, m - 1, n - 1), //replace
                distance(str1, str2, m - 1, n) //delete
        );

    }
}
