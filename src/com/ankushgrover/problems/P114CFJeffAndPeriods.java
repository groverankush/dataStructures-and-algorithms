package com.ankushgrover.problems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 15/09/19
 * <p>
 * http://codeforces.com/problemset/problem/352/B
 */
public class P114CFJeffAndPeriods {

    public static void main(String[] args) {

        P114CFJeffAndPeriods obj = new P114CFJeffAndPeriods();
        obj.run1();

    }

    private void run() {

        Scanner in = new Scanner(System.in);

        int size = in.nextInt(), count = 0;

        int[][] arr = new int[100000][2]; // Last position - Common difference

        for (int a[] : arr) {
            Arrays.fill(a, -2);
        }

        for (int i = 0; i < size; i++) {
            int num = in.nextInt();
            int[] pair = arr[num - 1];

            if (pair[1] == -1)
                continue;

            if (pair[0] == -2) {
                count++;
                pair[0] = i;
                pair[1] = 0;
            } else {
                if (pair[1] == 0) {
                    pair[1] = i - pair[0];
                    pair[0] = i;
                } else {
                    if (i - pair[0] != pair[1]) {
                        pair[1] = -1;
                        count--;
                    } else {
                        pair[1] = i - pair[0];
                        pair[0] = i;
                    }
                }
            }
        }


        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            int[] pair = arr[i];

            if (pair[1] > -1) {
                builder.append(i + 1).append(" ").append(pair[1]).append("\n");
                //System.out.println((i + 1) + " " + pair[1]);
            }
        }
        System.out.println(count);
        System.out.print(builder.toString());

    }

    private void run1() {
        Scanner in = new Scanner(System.in);

        int size = in.nextInt(), count = 0;

        int[] input = new int[size];

        int max = 0;

        for (int i = 0; i < size; i++) {
            input[i] = in.nextInt();
            if (max < input[i]) {
                max = input[i];
            }
        }

        int[][] arr = new int[max][2]; // Last position - Common difference

        for (int a[] : arr) {
            Arrays.fill(a, -2);
        }

        for (int i = 0; i < size; i++) {
            int num = input[i];
            int[] pair = arr[num - 1];

            if (pair[1] == -1)
                continue;

            if (pair[0] == -2) {
                count++;
                pair[0] = i;
                pair[1] = 0;
            } else {
                if (pair[1] == 0) {
                    pair[1] = i - pair[0];
                    pair[0] = i;
                } else {
                    if (i - pair[0] != pair[1]) {
                        pair[1] = -1;
                        count--;
                    } else {
                        pair[1] = i - pair[0];
                        pair[0] = i;
                    }
                }
            }
        }


        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            int[] pair = arr[i];

            if (pair[1] > -1) {
                builder.append(i + 1).append(" ").append(pair[1]).append("\n");
                //System.out.println((i + 1) + " " + pair[1]);
            }
        }

        System.out.println(count);
        System.out.print(builder.toString());

    }
}
