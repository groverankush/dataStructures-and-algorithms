package com.ankushgrover.problems;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 08/05/20
 *
 * Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 * Output: false
 *
 * Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * Output: true
 */
public class P147LCCheckIfItIsAStraightLine {

    public static void main(String[] args) {
    }

    public boolean checkStraightLine(int[][] coordinates) {

        if(coordinates.length == 2)
            return true;

        double cross = getCrossProduct(coordinates[0],coordinates[1]);

        for(int i = 1 ; i < coordinates.length-1; i++){
            if(cross != getCrossProduct(coordinates[i], coordinates[i+1]))
                return false;
        }

        return true;

    }

    private double getCrossProduct(int[] p1, int [] p2){
        //return (p1[0] * p2[1] ) - (p2[0] * p1[1]);
        return  1.0 * (p2[1] - p1[1] )  / (p2[0] - p1[0]) * 1.0;
    }
}
