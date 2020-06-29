package com.ankushgrover.problems;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 29/06/20
 * <p>
 * https://leetcode.com/problems/unique-paths/
 * <p>
 * #dp #dynamicProgramming #dfs
 */
public class P177LCMUniquePaths {

    public static void main(String[] args) {
    }

    //#dp
    public int uniquePaths(int m, int n) {

        int arr[][] = new int[m][n];

        for (int i = 0; i < n; i++) {
            arr[0][i] = 1;
        }

        for (int i = 0; i < m; i++) {
            arr[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
            }
        }

        return arr[m - 1][n - 1];
    }

    //#dfs
    public int uniquePathsDfs(int m, int n) {
        return paths(m, n, 0, 0);
    }

    private int paths(int m, int n, int a, int b) {
        if (a == m && b == n)
            return 1;

        if (a > m || b > n)
            return 0;

        return paths(m, n, a + 1, b) + paths(m, n, a, b + 1);

    }
}
