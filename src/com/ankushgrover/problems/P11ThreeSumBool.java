package com.ankushgrover.problems;

import java.util.Arrays;
import java.util.HashSet;

public class P11ThreeSumBool {

    public static void main(String[] args) {

        int[] arr = {8,8,8,8,8,8,8,8};
        int target = 25;

        long prev = System.nanoTime();

        System.out.println(threeSumHashing(arr, target));
        System.out.println("Time Taken: " + (System.nanoTime() - prev));

        prev = System.nanoTime();

        System.out.println(threeSum(arr, target));
        System.out.println("Time Taken: " + (System.nanoTime() - prev));
    }

    private static boolean threeSumHashing(int[] arr, int target) {

        for (int i = 0; i < arr.length - 2; i++) {

            int subTarget = target - arr[i];
            HashSet<Integer> set = new HashSet<>();

            for (int j = i + 1; j < arr.length; j++) {

                if (set.contains(subTarget - arr[j])) {
                    System.out.println(String.format("[%d, %d, %d]", arr[i], arr[j], subTarget - arr[j]));
                    return true;
                }

                set.add(arr[j]);
            }
        }

        return false;
    }

    private static boolean threeSum(int[] arr, int target) {

        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 2; i++) {

            int start = i + 1;
            int end = arr.length - 1;

            int subTarget = target - arr[i];

            while (start < end) {
                int sum = arr[start] + arr[end];
                if (sum == subTarget) {
                    System.out.println(String.format("[%d, %d, %d]", arr[i], arr[start], arr[end]));
                    return true;
                }


                if (sum < subTarget)
                    start++;
                else end--;
            }

        }
        return false;
    }


}
