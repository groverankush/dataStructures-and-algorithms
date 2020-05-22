package com.ankushgrover.problems;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 21/05/20
 *
 * https://leetcode.com/problems/count-square-submatrices-with-all-ones/
 */
public class P157LCCountSquares {

    public static void main(String[] args) {
    }

    // Unoptimized
    public int countSquares(int[][] matrix) {

        int count = 0;
        for(int side = 1; side <= Math.min(matrix.length, matrix[0].length); side++){

            count += countIndividual(matrix, side);

        }

        return count;

    }


    private int countIndividual(int [][] matrix, int side){
        int count = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(countHelper(matrix, i, j, side))
                    count++;
            }
        }

        return count;
    }

    private boolean countHelper(int [][] matrix, int x, int y, int side){

        if(x+side-1 >= matrix.length || y+side-1 >= matrix[0].length)
            return false;

        for(int i = 0 ; i < side; i++){

            for(int j = 0 ; j < side; j++){

                if(matrix[x+i][y+j] == 0)
                    return false;

            }

        }

        return true;

    }
}
