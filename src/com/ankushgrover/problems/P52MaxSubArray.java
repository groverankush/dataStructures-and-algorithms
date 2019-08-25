package com.ankushgrover.problems;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 25/08/19
 *
 * https://leetcode.com/problems/maximum-subarray/
 */
public class P52MaxSubArray {

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 2, 1, 99, 43, 21, -1, -56, -12, 434, -53};


        System.out.println(maxSubArray(arr));
    }


    private static int maxSubArray(int[] nums) {

        int max = nums[0];
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            max = Math.max(sum, max);
        }

        return max;

    }


}
