package com.ankushgrover.prep;

import java.util.Arrays;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 14/04/21
 * <p>
 * https://leetcode.com/problems/wiggle-sort-ii/
 */
public class I3LCMWiggleSortII {

    public static void main(String[] args) {

    }

    public void wiggleSort(int[] nums) {

        int arr[] = Arrays.copyOf(nums, nums.length);

        Arrays.sort(arr);

        int index = nums.length - 1;

        for (int i = 1; i < nums.length; i += 2) {
            nums[i] = arr[index--];
        }

        for (int i = 0; i < nums.length; i += 2) {
            nums[i] = arr[index--];
        }

    }
}
