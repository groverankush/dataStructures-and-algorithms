package com.ankushgrover.problems;

import java.util.Scanner;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 12/09/19
 * <p>
 * http://codeforces.com/problemset/problem/272/A
 */
public class P98DimaAndFriends {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int friends = in.nextInt();
        int sum = 0;

        for (int i = 0; i < friends; i++) {
            sum += in.nextInt();
        }

        int count = 0;

        for (int i = 1; i <= 5; i++) {
            if ((sum + i) % (friends + 1) != 1)
                count++;
        }

        System.out.print(count);
    }
}
