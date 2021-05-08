package com.ankushgrover.prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 23/04/21
 * <p>
 * https://leetcode.com/problems/3sum/
 */
public class I10LCM3Sum {

    public static void main(String[] args) {
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3)
            return new ArrayList<>();

        Arrays.sort(nums);

        int i = 0;

        ArrayList<List<Integer>> result = new ArrayList<>();

        while (i < nums.length) {
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {

                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);
                    j = increment(j, nums);
                    k = decrement(k, nums);
                } else if (sum < 0) {
                    j = increment(j, nums);
                } else {
                    k = decrement(k, nums);
                }

            }

            i = increment(i, nums);

        }

        return result;
    }

    int increment(int index, int[] arr) {
        int i = index + 1;
        while (i < arr.length && arr[i] == arr[index]) {
            i++;
        }

        return i;
    }

    int decrement(int index, int[] arr) {
        int i = index - 1;
        while (i >= 0 && arr[i] == arr[index]) {
            i--;
        }

        return i;
    }
}
