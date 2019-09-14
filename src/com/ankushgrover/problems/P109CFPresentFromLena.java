package com.ankushgrover.problems;

import java.util.Scanner;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 14/09/19
 * <p>
 * http://codeforces.com/problemset/problem/118/B
 */
public class P109CFPresentFromLena {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();


        int space = n, num = 0, count = 1, cCount = 0, max = n;
        for (int i = 0; i <= n * 2; i++) {
            for (int j = 0; j <= max; j++) {
                if (j < space) {
                    System.out.print("  ");
                } else if (num >= 0 && cCount < count) {
                    System.out.print(num);
                    if (j != max)
                        System.out.print(" ");
                    if (j < n) {
                        num++;
                    } else num--;
                    cCount++;
                }

            }
            cCount = 0;
            num = 0;
            if (i <= n) {
                count += 2;
            } else {
                count -= 2;
            }
            if (i < n) {
                max++;
                space--;
            } else {
                space++;
                max--;
            }

            System.out.println();
        }
    }
}
