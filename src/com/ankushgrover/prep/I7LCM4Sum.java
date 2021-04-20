package com.ankushgrover.prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 20/04/21
 * <p>
 * https://leetcode.com/problems/4sum/
 */
public class I7LCM4Sum {

    public static void main(String[] args) {
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {

        if (nums.length < 4) {
            return new ArrayList<>();
        }

        ArrayList<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        int i = 0;

        while (i < nums.length) {

            int j = i + 1;

            while (j < nums.length) {

                int k = j + 1;
                int l = nums.length - 1;

                while (k < l) {

                    int sum = nums[i] + nums[j] + nums[k] + nums[l];

                    if (sum == target) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[l]);
                        res.add(list);
                        k = increment(nums, k);
                        l = decrement(nums, l);
                    } else if (sum > target) {
                        l = decrement(nums, l);
                    } else {
                        k = increment(nums, k);
                    }

                }

                j = increment(nums, j);

            }

            i = increment(nums, i);

        }

        return res;
    }


    int increment(int arr[], int index) {
        int temp = arr[index++];

        while (index < arr.length) {

            if (arr[index] != temp)
                break;
            index++;

        }

        return index;

    }

    int decrement(int arr[], int index) {
        int temp = arr[index--];

        while (index >= 0) {

            if (arr[index] != temp)
                break;
            index--;

        }

        return index;

    }
}
