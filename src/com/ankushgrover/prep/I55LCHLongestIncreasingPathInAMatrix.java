package com.ankushgrover.prep;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 24/07/21
 */
public class I55LCHLongestIncreasingPathInAMatrix {

    public static void main(String[] args) {

        I55LCHLongestIncreasingPathInAMatrix obj = new I55LCHLongestIncreasingPathInAMatrix();
        int[][] matrix = {{7, 8, 9}, {9, 7, 6}, {7, 2, 3}};
        System.out.println(obj.longestIncreasingPath(matrix));

    }


    public int longestIncreasingPath(int[][] matrix) {
        return approach1(matrix);
    }

    private int approach1(int[][] matrix) {
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                int[][] visited = new int[matrix.length][matrix[0].length];
                int length = dfs(matrix, visited, i, j);
                res = Math.max(length, res);
            }
        }

        return res;
    }

    private int dfs(int[][] matrix, int[][] visited, int i, int j) {
        visited[i][j] = 1;

        int[] dx = {0, 0, 1, -1};

        int max = 0;
        for (int k = 0; k < 4; k++) {
            int ni = i + dx[3 - k];
            int nj = j + dx[k];

            if (isValid(matrix, visited, i, j, ni, nj)) {
                int length = 1 + dfs(matrix, visited, ni, nj);

                max = Math.max(max, length);

                visited[ni][nj] = 0;
                /*if(length > max){
                    max = length;
                }else{
                    visited[ni][nj] = 0;
                }*/
            }
        }

        return Math.max(1, max);

    }

    private boolean isValid(int[][] matrix, int[][] visited, int i, int j, int ni, int nj) {
        return ni >= 0 && ni < matrix.length && nj >= 0 && nj < matrix[0].length && visited[ni][nj] != 1 && matrix[ni][nj] > matrix[i][j];
    }
}
