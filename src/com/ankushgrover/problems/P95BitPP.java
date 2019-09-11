package com.ankushgrover.problems;

import java.util.Scanner;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 11/09/19
 * <p>
 * http://codeforces.com/problemset/problem/282/A
 */
public class P95BitPP {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int cases = in.nextInt();

        int x = 0;
        while (cases-- > 0) {
            String s = in.next();
            switch (s) {
                case "X++":
                    x++;
                    break;
                case "++X":
                    ++x;
                    break;
                case "X--":
                    x--;
                    break;
                case "--X":
                    --x;
                    break;
            }
        }

        System.out.println(x);
    }
}
