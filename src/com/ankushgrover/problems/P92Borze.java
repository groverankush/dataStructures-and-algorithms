package com.ankushgrover.problems;

import java.util.Scanner;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 10/09/19
 * <p>
 * http://codeforces.com/problemset/problem/32/B
 */
public class P92Borze {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.next();


        s = s.replaceAll("--", "2");
        s = s.replaceAll("-.", "1");
        s = s.replaceAll("\\.", "0");

        System.out.println(s);


    }
}