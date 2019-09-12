package com.ankushgrover.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 12/09/19
 * <p>
 * http://codeforces.com/problemset/problem/450/A
 */
public class P97JzzuAndChildren {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int size = in.nextInt();
        int candies = in.nextInt();

        List<Integer> cList = new ArrayList<>(size); //candies list
        List<Integer> pList = new ArrayList<>(size); // position list


        for (int i = 0; i < size; i++) {
            cList.add(in.nextInt());
            pList.add(i + 1);
        }

        while (cList.size() > 1) {
            if (cList.get(0) - candies > 0) {
                int rem = cList.get(0) - candies;
                int pos = pList.get(0);
                cList.remove(0);
                pList.remove(0);
                cList.add(rem);
                pList.add(pos);
            } else {
                cList.remove(0);
                pList.remove(0);
            }
        }

        System.out.print(pList.get(0));

    }
}
