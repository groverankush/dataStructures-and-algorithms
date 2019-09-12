package com.ankushgrover.problems;

import java.util.Scanner;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 12/09/19
 * <p>
 * http://codeforces.com/problemset/problem/34/A
 */
public class P102Reconnaissance2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int size = in.nextInt();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = in.nextInt();
        }

        int min = Math.abs(arr[0] - arr[size - 1]);
        int f = 1, s = size;

        for (int i = 1; i < size; i++) {
            if (min > Math.abs(arr[i] - arr[i - 1])) {
                min = Math.abs(arr[i] - arr[i - 1]);
                f = i + 1;
                s = i;
            }
        }

        System.out.print(s + " " + f);
    }
}
