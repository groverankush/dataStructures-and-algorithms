package com.ankushgrover.problems;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 03/06/20
 */
public class P163LCETwoCityScheduling {

    public static void main(String[] args) {
        P163LCETwoCityScheduling obj = new P163LCETwoCityScheduling();
        int [][] arr = {{10,20}, {30,20}, {400,50}, {30,200}};
        System.out.println(obj.twoCitySchedCost(arr));
    }

    public int twoCitySchedCost(int[][] costs) {

        int [] diff = new int[costs.length];
        for(int [] cost : costs){

        }

        Arrays.sort(costs, (ints, t1) -> {
            if(ints[0] == t1[0])
                return  t1[1]-ints[1];
            return ints[0] - t1[0];
        });

        boolean takeA = true;
        int sum1 = 0;
        for(int i = 0 ; i < costs.length; i++){
            if(i == costs.length/2)
                takeA = false;
            if(takeA)
                sum1+=costs[i][0];
            else sum1+= costs[i][1];
        }

        Arrays.sort(costs, (ints, t1) -> {
            if(ints[1] == t1[1])
                return  t1[0]-ints[0];
            return ints[1] - t1[1];
        });

        takeA = false;
        int sum2 = 0;
        for(int i = 0 ; i < costs.length; i++){
            if(i == costs.length/2)
                takeA = true;
            if(takeA)
                sum2+=costs[i][0];
            else sum2+= costs[i][1];
        }
        return Math.min(sum1, sum2);

    }


    public int twoCitySchedCost1(int[][] costs) {
        Arrays.sort(costs, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return (a[1] - a[0]) - (b[1] - b[0]);
            }
        });
        int cost = 0;
        for (int i = 0; i < costs.length / 2; i++) {
            cost += costs[i][1] + costs[costs.length-i-1][0];
        }
        return cost;
    }
}
