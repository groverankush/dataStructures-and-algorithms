package com.ankushgrover.prep;

import java.util.HashSet;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 23/04/21
 */
public class I11LCMSetMatrixZeroes {

    public static void main(String[] args) {
        I11LCMSetMatrixZeroes obj = new I11LCMSetMatrixZeroes();
        int matrix[][] = {{1, 2, 3, 4}, {5, 0, 7, 8}, {0, 10, 11, 12}, {13, 14, 15, 0}};
        obj.setZeroesOptimized(matrix);
    }


    public void setZeroesOptimized(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean firstRow = false;
        boolean firstCol = false;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (matrix[i][j] == 0) {

                    if (i == 0)
                        firstRow = true;

                    if (j == 0)
                        firstCol = true;

                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < rows; i++) {
            if (matrix[i][0] == 0) {

                for (int j = 1; j < cols; j++) {
                    matrix[i][j] = 0;
                }

            }

        }

        for (int i = 1; i < cols; i++) {
            if (matrix[0][i] == 0) {

                for (int j = 1; j < rows; j++) {
                    matrix[j][i] = 0;
                }

            }
        }

        if (firstRow) {
            for (int i = 0; i < cols; i++) {
                matrix[0][i] = 0;
            }
        }

        if (firstCol) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public void setZeroes(int[][] matrix) {
        HashSet<Integer> rows = new HashSet<>();
        HashSet<Integer> cols = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for (Integer row : rows) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[row][i] = 0;
            }
        }

        for (Integer col : cols) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][col] = 0;
            }
        }

    }
}
