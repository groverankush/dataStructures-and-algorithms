package com.ankushgrover.problems;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 03/09/19
 *
 * https://leetcode.com/problems/rotate-image/
 */
public class P74RotateImage {

    public static void main(String[] args) {
    }

    private static void rotate(int[][] matrix) {


        // transpose

        for(int i = 0 ; i < matrix.length; i++){
            for(int j = i; j < matrix.length; j++){

                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;

            }
        }

        // reverse rows
        for(int i = 0; i < matrix.length; i++){

            for(int j = 0; j < matrix.length/2; j++){

                int index = matrix.length - 1 - j;
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][index];
                matrix[i][index] = temp;

            }

        }

    }
}
