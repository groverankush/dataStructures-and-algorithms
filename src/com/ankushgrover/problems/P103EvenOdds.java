package com.ankushgrover.problems;

import java.util.Scanner;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 12/09/19
 * <p>
 * http://codeforces.com/problemset/problem/318/A
 */
public class P103EvenOdds {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        long n = in.nextLong(), k = in.nextLong();

        long lastOdd = n % 2 == 0 ? ((n / 2) - 1) : n / 2;
        long lastEven = n - 1;

        if (k - 1 <= lastOdd) {
            System.out.print(1 + ((k - 1) * 2));
        } else {
            System.out.print(((k - 1 - lastOdd) * 2));
        }

    }
}
