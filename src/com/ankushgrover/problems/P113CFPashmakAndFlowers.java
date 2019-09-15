package com.ankushgrover.problems;

import java.util.Scanner;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 15/09/19
 * <p>
 * http://codeforces.com/problemset/problem/459/B
 */
public class P113CFPashmakAndFlowers {

    public static void main(String[] args) {
        P113CFPashmakAndFlowers obj = new P113CFPashmakAndFlowers();


        //System.out.println(sum);
        obj.run();
    }

    private void run() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        long maxTimes = 0, minTimes = 0, times = 0;


        for (int i = 0; i < n; i++) {

            times += i;

            int t = in.nextInt();

            if (max == t) {
                maxTimes++;
            }
            if (min == t)
                minTimes++;

            if (max < t) {
                max = t;
                maxTimes = 1;
            }
            if (min > t) {
                min = t;
                minTimes = 1;
            }


        }

        in.close();

        times = max == min ? times : maxTimes * minTimes;
        System.out.print((max - min) + " " + times);
    }
}
