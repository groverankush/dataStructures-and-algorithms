package com.ankushgrover.prep.dp;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 16/05/21
 */
public class P3CanSum {

    public static void main(String[] args) {
        P3CanSum obj = new P3CanSum();
        int[] nums = {7, 14};
        int target = 300;

        System.out.println("Tabulation: " + obj.tabulation(nums, target));

        Boolean[] dp = new Boolean[target + 1];

        Arrays.fill(dp, null);
        System.out.println("dp with arr: " + obj.dpWithArr(nums, target, dp));
        System.out.println("dp: " + obj.dp(nums, target, new HashMap<>()));
        System.out.println("Recursion: " + obj.recur(nums, target));


    }

    boolean recur(int[] nums, int target) {

        if (target == 0)
            return true;

        if (target < 0)
            return false;

        boolean result = false;
        for (int num : nums) {
            result = result || recur(nums, target - num);
        }
        return result;

    }

    boolean dp(int nums[], int target, HashMap<Integer, Boolean> map) {

        if (map.containsKey(target)) {
            return map.get(target);
        }

        if (target == 0)
            return true;

        if (target < 0)
            return false;

        boolean result = false;

        for (int num : nums) {
            boolean res = dp(nums, target - num, map);
            map.put(target, res);
            result = result || res;
        }
        return result;

    }

    boolean dpWithArr(int nums[], int target, Boolean[] memo) {

        if (target < 0)
            return false;

        if (memo[target] != null) {
            return memo[target];
        }

        if (target == 0)
            return true;

        boolean result = false;

        for (int num : nums) {
            boolean res = dpWithArr(nums, target - num, memo);
            memo[target] = res;
            result = result || res;
        }
        return result;

    }

    boolean tabulation(int[] nums, int target) {

        boolean[] dp = new boolean[target + 1];

        dp[0] = true;

        for (int i = 0; i < dp.length; i++) {

            for (int num : nums) {
                if (dp[i]) {
                    int index = i + num;
                    if (index < dp.length) {
                        dp[index] = true;
                    }
                }
            }

        }

        return dp[target];
    }
}
