package com.ankushgrover.problems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 11/09/19
 * <p>
 * http://codeforces.com/problemset/problem/275/A
 */
public class P94LightsOut {

    public static void main(String[] args) {

        int[][] arr = new int[3][3];

        for (int[] row : arr) {
            Arrays.fill(row, 1);
        }

        Scanner in = new Scanner(System.in);

        int value;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                value = in.nextInt();

                arr[i][j] = value % 2 == 0 ? arr[i][j] : arr[i][j] == 0 ? 1 : 0;

                if (i + 1 < 3)
                    arr[i + 1][j] = value % 2 == 0 ? arr[i + 1][j] : arr[i + 1][j] == 0 ? 1 : 0;
                if (j + 1 < 3)
                    arr[i][j + 1] = value % 2 == 0 ? arr[i][j + 1] : arr[i][j + 1] == 0 ? 1 : 0;
                if (i - 1 >= 0)
                    arr[i - 1][j] = value % 2 == 0 ? arr[i - 1][j] : arr[i - 1][j] == 0 ? 1 : 0;
                if (j - 1 >= 0)
                    arr[i][j - 1] = value % 2 == 0 ? arr[i][j - 1] : arr[i][j - 1] == 0 ? 1 : 0;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}
