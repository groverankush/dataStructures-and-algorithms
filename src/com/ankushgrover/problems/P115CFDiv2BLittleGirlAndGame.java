package com.ankushgrover.problems;

import java.util.Scanner;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 16/09/19
 * <p>
 * http://codeforces.com/problemset/problem/276/B
 */
public class P115CFDiv2BLittleGirlAndGame {

    public static void main(String[] args) {

        P115CFDiv2BLittleGirlAndGame obj = new P115CFDiv2BLittleGirlAndGame();
        obj.run();

    }

    private void run() {

        Scanner in = new Scanner(System.in);

        String s = in.next();

        int[] arr = new int[26];

        int odds = 0;

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            arr[index]++;
            if (arr[index] % 2 != 0)
                odds++;
            else odds--;
        }
        String result;

        if (odds <= 1) {
            result = "First";
        } else if (odds % 2 == 0) {
            result = "Second";
        } else result = "First";

        System.out.println(result);

    }
}
