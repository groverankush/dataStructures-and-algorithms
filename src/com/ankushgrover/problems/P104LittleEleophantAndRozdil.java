package com.ankushgrover.problems;

import java.util.Scanner;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 12/09/19
 * <p>
 * http://codeforces.com/problemset/problem/205/A
 */
public class P104LittleEleophantAndRozdil {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int size = in.nextInt();

        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < size; i++) {
            int num = in.nextInt();

            if (min > num) {
                min = num;
                index = i + 1;

            } else if (min == num) {
                index = -1;
            }
        }

        System.out.print(index == -1 ? "Still Rozdil" : index);
    }
}
