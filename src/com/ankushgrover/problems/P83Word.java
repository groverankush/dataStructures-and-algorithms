package com.ankushgrover.problems;

import java.util.Scanner;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 11/09/19
 * <p>
 * http://codeforces.com/problemset/problem/59/A
 */
public class P83Word {

    public static void main(String[] args) {

        char[] arr = new Scanner(System.in).next().toCharArray();

        int lower = 0, upper = 0;
        for (char ch : arr) {
            if (Character.isLowerCase(ch))
                lower++;
            else upper++;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = upper > lower ? Character.toUpperCase(arr[i]) : Character.toLowerCase(arr[i]);
        }

        System.out.print(String.valueOf(arr));

    }
}
