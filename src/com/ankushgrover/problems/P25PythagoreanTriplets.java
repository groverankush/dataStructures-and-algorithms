package com.ankushgrover.problems;

import java.util.Arrays;

/**
 * Given a list of numbers, find if there exists a pythagorean triplet in that list. A pythagorean triplet is 3
 * variables a, b, c where a^2 + b^2 = c^2
 * <p>
 * Example:
 * Input: [3, 5, 12, 5, 13]
 * Output: True
 * Here, 5^2 + 12^2 = 13^2.
 */
public class P25PythagoreanTriplets {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(triplets(arr));
    }

    private static boolean triplets(int[] arr) {

        Arrays.sort(arr);

        for (int i = arr.length - 1; i > 1; i--) {

            int target = arr[i] * arr[i];

            int start = 0, end = i - 1;

            while (start < end) {
                int sub = (arr[start] * arr[start]) + (arr[end] * arr[end]);
                if (sub == target)
                    return true;

                if (sub < target)
                    start++;
                else end--;

            }
        }

        return false;
    }
}
