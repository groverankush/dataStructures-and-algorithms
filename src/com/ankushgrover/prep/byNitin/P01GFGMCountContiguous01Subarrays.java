package com.ankushgrover.prep.byNitin;

import java.util.HashMap;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 22/06/21
 * <p>
 * Given a binary array [0,1] of size n. Find the number of sub arrays where the number of 0s equals number of 1s
 * <p>
 * https://practice.geeksforgeeks.org/problems/count-subarrays-with-equal-number-of-1s-and-0s-1587115620/1
 */
public class P01GFGMCountContiguous01Subarrays {

    public static void main(String[] args) {

        int arr[] = {1, 0, 0, 1, 0, 1, 1};
        //int arr[] = {1, 1,1,1,0};
        System.out.println(countSubarrWithEqualZeroAndOne(arr, arr.length));
    }

    static int countSubarrWithEqualZeroAndOne(int arr[], int n) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] == 0 ? -1 : 1;
        }

        int sum = 0;
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];

            if (map.containsKey(sum)) {
                res += map.get(sum);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);

        }

        return res;
    }
}
