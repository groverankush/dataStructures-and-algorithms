package com.ankushgrover.problems;

import java.util.Scanner;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 13/09/19
 * <p>
 * http://codeforces.com/problemset/problem/58/A
 */
public class P107CFChatRoom {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        char[] arr = in.next().toCharArray();
        String hello = "hello";

        int index = 0;

        for (char ch : arr) {
            if (ch == hello.charAt(index)) {
                index++;
            }

            if (index == hello.length()) {
                System.out.print("YES");
                return;
            }
        }

        System.out.print("NO");


    }
}
