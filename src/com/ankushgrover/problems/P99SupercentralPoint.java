package com.ankushgrover.problems;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 12/09/19
 * <p>
 * http://codeforces.com/problemset/problem/165/A
 */
public class P99SupercentralPoint {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int size = in.nextInt();


        List<Pair<Integer, Integer>> list = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            list.add(new Pair<>(in.nextInt(), in.nextInt()));
        }

        int count = 0;

        for (int i = 0; i < size; i++) {
            boolean[] arr = new boolean[4];
            Pair<Integer, Integer> ref = list.get(i);
            boolean flag = true;

            for (int j = 0; j < size; j++) {
                Pair<Integer, Integer> point = list.get(j);

                if (!arr[0]) {
                    arr[0] = point.getKey() < ref.getKey() && point.getValue().equals(ref.getValue());
                }
                if (!arr[1]) {
                    arr[1] = point.getKey() > ref.getKey() && point.getValue().equals(ref.getValue());
                }
                if (!arr[2]) {
                    arr[2] = point.getKey().equals(ref.getKey()) && point.getValue() < ref.getValue();
                }
                if (!arr[3]) {
                    arr[3] = point.getKey().equals(ref.getKey()) && point.getValue() > ref.getValue();
                }
            }

            for (int k = 0; k < 4; k++) {
                if (!arr[k]) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                count++;
        }

        System.out.print(count);

    }


}
