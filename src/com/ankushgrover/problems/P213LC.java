package com.ankushgrover.problems;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 23/08/20
 */
public class P213LC {

    public static void main(String[] args) {

        int rec[][] = {{1, 1, 5, 5}};
        Solution obj = new Solution(rec);

        for (int i = 0; i < 10; i++) {
            System.out.println(Arrays.toString(obj.pick()));
        }


    }


    static class Solution {

        int rects[][];

        public Solution(int[][] rects) {
            this.rects = rects;
        }

        public int[] pick() {
            int rec = getRandom(0, rects.length - 1);

            int randomMin = rects[rec][0];
            int randomMax = rects[rec][2] - rects[rec][0];

            System.out.println("x: " + randomMin + "  y: " + randomMax);

            int x = getRandom(randomMin, randomMax);

            randomMin = rects[rec][1];
            randomMax = rects[rec][3] - rects[rec][1];

            System.out.println("x: " + randomMin + "  y: " + randomMax);


            int y = getRandom(randomMin, randomMax);


            int[] res = {x, y};

            return res;
        }

        private int getRandom(int min, int max) {
            return ThreadLocalRandom.current().nextInt(min, max + 1);
        }
    }
}
