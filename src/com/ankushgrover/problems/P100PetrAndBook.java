package com.ankushgrover.problems;

import java.util.Scanner;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 12/09/19
 * <p>
 * http://codeforces.com/problemset/problem/139/A
 */
public class P100PetrAndBook {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int size = in.nextInt();

        int[] pages = new int[7];

        for (int i = 0; i < 7; i++) {
            pages[i] = in.nextInt();
        }

        int count = 0;
        int index = 0;

        while (count + pages[index] < size) {

            count += pages[index];

            index = (index + 1) % 7;

        }

        System.out.print(index + 1);

    }
}
