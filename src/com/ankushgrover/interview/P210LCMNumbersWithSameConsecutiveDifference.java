package com.ankushgrover.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 18/08/20
 * <p>
 * https://leetcode.com/problems/numbers-with-same-consecutive-differences/
 * <p>
 * #medium
 */
public class P210LCMNumbersWithSameConsecutiveDifference {

    public static void main(String[] args) {
    }

    public int[] numsSameConsecDiff(int N, int K) {

        List<Integer> res = new ArrayList<>();

        for (int i = N == 1 ? 0 : 1; i < 10; i++) {
            List<Integer> list = new ArrayList<>();
            generator(i, 1, N, K, list);
            res.addAll(list);
        }


        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }

        return arr;
    }

    void generator(int num, int size, int n, int diff, List<Integer> list) {

        if (size == n) {
            list.add(num);
            return;
        }

        int digit = num % 10;

        if (digit + diff < 10) {
            generator((num * 10) + digit + diff, size + 1, n, diff, list);
        }
        if ((digit + diff != digit - diff) && digit - diff >= 0) {
            generator((num * 10) + (digit - diff), size + 1, n, diff, list);
        }

    }
}