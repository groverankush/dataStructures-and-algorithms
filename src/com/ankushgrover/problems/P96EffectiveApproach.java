package com.ankushgrover.problems;

import java.util.Scanner;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 11/09/19
 * <p>
 * http://codeforces.com/problemset/problem/227/B
 */
public class P96EffectiveApproach {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();

        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[in.nextInt() - 1] = i;
        }


        int cases = in.nextInt();


        long f = 0, s = 0;
        for (int i = 0; i < cases; i++) {
            int c = in.nextInt();


            f = f + arr[c - 1] + 1;
            s = s + size - arr[c - 1];

        }

        System.out.print(f + " " + s);
    }
}
