package com.ankushgrover.problems;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 08/09/19
 * <p>
 * https://leetcode.com/problems/number-of-islands/
 */
public class P86NumberOfIslands {

    public static void main(String[] args) {
    }

    public int numIslands(char[][] grid) {

        if (grid.length == 0)
            return 0;

        boolean visited[][] = new boolean[grid.length][grid[0].length];
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    markVisited(grid, visited, i, j);
                }
            }
        }
        return count;
    }

    private boolean markVisited(char[][] grid, boolean[][] visited, int i, int j) {

        if (i >= grid.length || i < 0 || j >= grid[0].length || j < 0) {
            return false;
        }

        if (grid[i][j] == '0')
            return false;

        if (visited[i][j])
            return visited[i][j];


        visited[i][j] = true;

        markVisited(grid, visited, i, j + 1);
        markVisited(grid, visited, i + 1, j);
        markVisited(grid, visited, i, j - 1);
        markVisited(grid, visited, i - 1, j);


        return true;

    }

    public int numIslandsV2(char[][] grid) {

        if (grid.length == 0)
            return 0;

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    markVisitedV2(grid, i, j);
                }
            }
        }
        return count;
    }

    private void markVisitedV2(char[][] grid, int i, int j) {

        if (i >= grid.length || i < 0 || j >= grid[0].length || j < 0) {
            return;
        }

        if (grid[i][j] == '0')
            return;


        grid[i][j] = '0';

        markVisitedV2(grid, i, j + 1);
        markVisitedV2(grid, i + 1, j);
        markVisitedV2(grid, i, j - 1);
        markVisitedV2(grid, i - 1, j);
    }
}
