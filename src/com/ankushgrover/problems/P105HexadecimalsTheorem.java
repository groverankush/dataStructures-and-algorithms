package com.ankushgrover.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 13/09/19
 * <p>
 * http://codeforces.com/problemset/problem/199/A
 */
public class P105HexadecimalsTheorem {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        Scanner in = new Scanner(System.in);

        int num = in.nextInt();

        int f = 0, s = 1, sum;

        list.add(f);
        list.add(s);

        while (f + s < num) {
            sum = f + s;
            list.add(sum);
            f = s;
            s = sum;
        }


        for (int i = 0; i < list.size(); i++) {
            f = i;
            s = list.size() - 1;

            while (s >= f) {

                sum = list.get(i) + list.get(f) + list.get(s);
                if (sum == num) {
                    System.out.print(list.get(i) + " " + list.get(f) + " " + list.get(s) + " ");
                    return;
                } else if (sum > num) {
                    s--;
                } else f++;

            }
        }

        System.out.print("I'm too stupid to solve this problem");

    }
}
