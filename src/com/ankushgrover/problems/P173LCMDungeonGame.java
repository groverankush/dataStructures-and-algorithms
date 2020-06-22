package com.ankushgrover.problems;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 22/06/20
 */
public class P173LCMDungeonGame {

    int fi = Integer.MAX_VALUE;

    public static void main(String[] args) {

        int arr[][] = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};

        P173LCMDungeonGame obj = new P173LCMDungeonGame();
        System.out.println(obj.calculateMinimumHP(arr));
    }

    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return 0;

        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] health = new int[m][n];

        health[m - 1][n - 1] = Math.max(1 - dungeon[m - 1][n - 1], 1);

        for (int i = m - 2; i >= 0; i--) {
            health[i][n - 1] = Math.max(health[i + 1][n - 1] - dungeon[i][n - 1], 1);
        }

        for (int j = n - 2; j >= 0; j--) {
            health[m - 1][j] = Math.max(health[m - 1][j + 1] - dungeon[m - 1][j], 1);
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int down = Math.max(health[i + 1][j] - dungeon[i][j], 1);
                int right = Math.max(health[i][j + 1] - dungeon[i][j], 1);
                health[i][j] = Math.min(right, down);
            }
        }

        return health[0][0];
    }

    private int dfs(int[][] arr, int x, int y, int cur, int total) {

        if (x == arr.length - 1 && y == arr[0].length - 1) {
            fi = Math.min(fi, total);
            return fi;
        }

        if (x >= arr.length || y >= arr[0].length)
            return total;

        int temp = cur + arr[x][y];
        if (temp < 1) {
            total = total + (1 + (-1 * temp));
            cur = 1;
        } else {
            cur = temp;
        }

        return Math.min(dfs(arr, x + 1, y, cur, total), dfs(arr, x, y + 1, cur, total));
    }
}
