package com.ankushgrover.problems;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 27/08/19
 *
 * https://leetcode.com/problems/house-robber/
 */
public class P61HouseRobber {

    public static void main(String[] args) {

        int [] arr = {1,2,2,1};

        System.out.println(rob(arr));

    }

    private static int rob(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;

        if(nums.length == 1)
            return nums[0];

        int []dp = new int [nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < nums.length;i++){
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }

        return dp[dp.length-1];
    }
}
