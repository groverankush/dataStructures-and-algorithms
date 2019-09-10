package com.ankushgrover.problems;

import java.util.Scanner;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 10/09/19
 * <p>
 * http://codeforces.com/problemset/problem/266/B
 */
public class P91QueueAtSchool {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int size = in.nextInt();
        int time = in.nextInt();

        char[] q = in.next().toCharArray();

        for (int i = 0; i < time; i++) {
            for (int j = 0; j < q.length - 1; j++) {

                if (q[j] == 'B' && q[j + 1] == 'G') {
                    q[j] = 'G';
                    q[j + 1] = 'B';
                    j++;
                }

            }
        }

        System.out.print(q);
    }
}
