package com.ankushgrover.problems;

import java.util.Scanner;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 10/09/19
 * <p>
 * http://codeforces.com/problemset/problem/263/A
 */
public class P90BeautifulMatrix {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (in.nextInt() == 1) {

                    System.out.print(Math.abs(2 - i) + Math.abs(2 - j));
                    break;

                }
            }
        }
    }

/*          0 0 0 0 0
            0 0 0 0 0
            0 0 0 0 0
            0 0 0 0 0
            0 0 1 0 0*/

}
