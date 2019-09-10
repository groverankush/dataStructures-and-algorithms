package com.ankushgrover.problems;

import java.util.Scanner;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 10/09/19
 * <p>
 * http://codeforces.com/problemset/problem/69/A
 */
public class P89YoungPhysicist {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        int[] vec = new int[3];
        for (int i = 0; i < cases; i++) {

            vec[0] += in.nextInt();
            vec[1] += in.nextInt();
            vec[2] += in.nextInt();

        }

        System.out.print(vec[0] == 0 && vec[1] == 0 && vec[2] == 0 ? "YES" : "NO");
    }

}
