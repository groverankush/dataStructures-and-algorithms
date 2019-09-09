package com.ankushgrover.problems;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 09/09/19
 * <p>
 * https://leetcode.com/problems/product-of-array-except-self/
 */
public class P88ProductArray {

    public static void main(String[] args) {
    }

    public int[] productExceptSelf(int[] nums) {

        if (nums.length == 0)
            return nums;

        if (nums.length == 1) {
            nums[0] = 1;
            return nums;
        }

        int[] res = new int[nums.length];

        res[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i];
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            nums[i] = nums[i] * nums[i + 1];
        }

        int first = nums[1];
        int last = res[nums.length - 2];

        for (int i = 1; i < nums.length - 1; i++) {
            nums[i] = nums[i + 1] * res[i - 1];
        }

        nums[0] = first;
        nums[nums.length - 1] = last;

        return nums;

    }
}
