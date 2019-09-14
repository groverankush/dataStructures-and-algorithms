package com.ankushgrover.problems;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 14/09/19
 * <p>
 * http://codeforces.com/problemset/problem/230/A
 */
public class P110CFDragons {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int pow = in.nextInt(), size = in.nextInt();


        List<Pair<Integer, Integer>> list = new ArrayList<>(size);


        for (int i = 0; i < size; i++) {
            list.add(new Pair<>(in.nextInt(), in.nextInt()));
        }

        list.sort(new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
                return p1.getKey() - p2.getKey();
            }
        });

        boolean lost = false;
        for (Pair<Integer, Integer> pair : list) {
            if (pair.getKey() >= pow) {
                lost = true;
                break;
            } else {
                pow += pair.getValue();
            }
        }

        System.out.print(lost ? "NO" : "YES");


    }
}
