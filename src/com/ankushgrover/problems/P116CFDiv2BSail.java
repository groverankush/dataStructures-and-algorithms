package com.ankushgrover.problems;

import java.util.Scanner;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 16/09/19
 * <p>
 * http://codeforces.com/problemset/problem/298/B
 */
public class P116CFDiv2BSail {

    public static void main(String[] args) {
        P116CFDiv2BSail obj = new P116CFDiv2BSail();
        obj.run();
    }

    private void run() {
        Scanner in = new Scanner(System.in);

        int size = in.nextInt(), sx = in.nextInt(), sy = in.nextInt(), ex = in.nextInt(), ey = in.nextInt();
        String str = in.next();

        char dx = sx > ex ? 'W' : 'E';
        char dy = sy > ey ? 'S' : 'N';

        for (int i = 0; i < str.length(); i++) {
            char dr = str.charAt(i);

            if (dr == dx && sx != ex) {
                if (dx == 'W') {
                    sx -= 1;
                } else sx += 1;
            }

            if (dr == dy && sy != ey) {
                if (dy == 'S') {
                    sy -= 1;
                } else sy += 1;
            }

            if (sx == ex && sy == ey) {
                System.out.println(i + 1);
                return;
            }

        }

        System.out.println(-1);
    }
}
