package com.ankushgrover.problems;

/**
 * https://leetcode.com/problems/single-number/submissions/
 */
public class P40SingleNumber {

    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 3, 4, 5, 5};
        System.out.println(singleNumber(nums));
    }

    private static int singleNumber(int[] nums) {

        if (nums == null || nums.length == 0)
            return 0;

        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {
            ans = ans ^ nums[i];
        }

        return ans;

    }


}
