package com.ankushgrover.problems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 13/09/19
 * <p>
 * http://codeforces.com/problemset/problem/337/A
 */
public class P106CCPuzzles {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int s = in.nextInt();
        int n = in.nextInt();


        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {

            arr[i] = in.nextInt();

        }

        Arrays.sort(arr);

        int diff = Integer.MAX_VALUE;
        for (int i = n - s; i >= 0; i--) {
            diff = Math.min(diff, arr[i + s - 1] - arr[i]);
        }

        System.out.print(diff);

    }

}
