package com.ankushgrover.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 14/04/21
 * <p>
 * https://www.hackerrank.com/challenges/array-left-rotation/problem
 */
public class P220HRELeftRotation {

    public static void main(String[] args) {
    }

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        // Write your code here

        if (d == arr.size()) {
            return arr;
        }

        ArrayList<Integer> res = new ArrayList<>();

        for (int i = d; i < arr.size(); i++) {

            res.add(arr.get(i));

        }

        for (int i = 0; i < d; i++) {
            res.add(arr.get(i));
        }

        return res;

    }
}
