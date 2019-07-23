package com.ankushgrover.problems;

import java.util.HashSet;

/**
 * You are given a list of numbers, and a target number k. Return whether or not there are two numbers in the list that add up to k.
 *
 * Example:
 * Given [4, 7, 1 , -3, 2] and k = 5,
 * return true since 4 + 1 = 5.
 *
 * def two_sum(list, k):
 *   # Fill this in.
 *
 * print two_sum([4,7,1,-3,2], 5)
 * # True
 *
 * Try to do it in a single pass of the list.
 */
public class P10TwoSumBool {

    public static void main(String[] args) {

        int[] arr = {4, 5, 7, 3, 5, 2, 5, 7, 1, 3, 5, 6, 9, 8};
        System.out.println(twoSumUnsorted(arr, 20));

    }

    private static boolean twoSumSorted(int[] arr, int target) {

        int i = 0, j = arr.length - 1;

        while (i < j) {
            int sum = arr[i] + arr[j];
            if (sum == target)
                return true;

            if (sum < target) {
                i++;
            } else j--;
        }

        return false;
    }

    private static boolean twoSumUnsorted(int[] arr, int target) {

        HashSet<Integer> set = new HashSet<>();

        for (int i : arr) {
            if (set.contains(target - i))
                return true;
            set.add(i);
        }
        return false;

    }
}
