package com.ankushgrover.problems;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 07/07/20
 */
public class P185LCMIslandPerimeter {

    public static void main(String[] args) {

        P185LCMIslandPerimeter obj = new P185LCMIslandPerimeter();
        int arr[][] = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        //int arr[][] = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        System.out.println(obj.islandPerimeter(arr));

    }

    public int islandPerimeter(int[][] grid) {

        int[][] visited = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return dfs(visited, grid, i, j, 0);

                }

            }
        }

        return 0;

    }

    private int dfs(int[][] visited, int grid[][], int x, int y, int perimeter) {

        visited[x][y] = 1;

        int xs[] = {0, 1, -1, 0};
        int ys[] = {1, 0, 0, -1};

        for (int i = 0; i < xs.length; i++) {
            if (isValid(visited, grid, x + xs[i], y + ys[i])) {
                perimeter = dfs(visited, grid, x + xs[i], y + ys[i], perimeter);
            } else if (!isVisited(visited, x + xs[i], y + ys[i])) {
                perimeter++;
            }
        }

        return perimeter;

    }

    private boolean isValid(int[][] visited, int grid[][], int i, int j) {

        return i >= 0 && i < visited.length && j >= 0 && j < visited[0].length && grid[i][j] == 1 && visited[i][j] == 0;

    }

    private boolean isVisited(int[][] visited, int i, int j) {
        return i >= 0 && i < visited.length && j >= 0 && j < visited[0].length && visited[i][j] == 1;
    }

    public int islandPerimeter2(int[][] grid) {
        int perimeter = 0;
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0)
                    continue;
                if (i == 0 || grid[i - 1][j] == 0) perimeter++;
                if (i == n - 1 || grid[i + 1][j] == 0) perimeter++;
                if (j == 0 || grid[i][j - 1] == 0) perimeter++;
                if (j == m - 1 || grid[i][j + 1] == 0) perimeter++;
            }
        return perimeter;
    }
}
