package com.ankushgrover.problems;

import java.util.Scanner;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 10/09/19
 * <p>
 * http://codeforces.com/problemset/problem/271/A
 */
public class P93BeautifulYear {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int year = in.nextInt();
        year++;
        boolean isValid = true;

        for (; true; year++) {
            int[] arr = new int[10];

            int y = year;
            isValid = true;
            for (int i = 0; i < 4; i++) {
                if (arr[y % 10] == 1) {
                    isValid = false;
                    break;
                }
                arr[y % 10] = 1;
                y = y / 10;
            }

            if (isValid) {
                System.out.println(year);
                break;
            }
        }
    }


}
