package com.ankushgrover.problems;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 03/09/19
 */
public class P72QueueReconstruction {

    public static void main(String[] args) {


        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};

        reconstructQueue(people);

        System.out.println(Arrays.toString(people));

    }

    private static int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return t2[0] - t1[0];
            }
        });


        for (int i = 0; i < people.length; i++) {


        }


        return people;

    }

}
