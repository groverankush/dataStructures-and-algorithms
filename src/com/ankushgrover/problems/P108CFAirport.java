package com.ankushgrover.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 14/09/19
 * <p>
 * http://codeforces.com/problemset/problem/218/B
 */
public class P108CFAirport {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int people = in.nextInt();
        int size = in.nextInt();

        Integer[] arr = new Integer[size];

        for (int i = 0; i < size; i++) {
            arr[i] = in.nextInt();
        }

        Arrays.sort(arr);


        List<Integer> list = new ArrayList<>(Arrays.asList(arr));

        int max = 0;

        int p = people, index;
        while (p > 0) {
            max += findMax(list);
            p--;
        }

        int min = 0;
        index = 0;
        while (people > 0) {
            min += arr[index];
            people--;
            arr[index]--;
            if (arr[index] == 0)
                index++;
        }

        System.out.print(max + " " + min);

    }

    private static int findMax(List<Integer> list) {
        int max = 0;
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
                index = i;
            }
        }

        list.set(index, list.get(index) - 1);
        return max;
    }
}
