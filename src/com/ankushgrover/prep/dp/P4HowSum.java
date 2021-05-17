package com.ankushgrover.prep.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 16/05/21
 */
public class P4HowSum {

    public static void main(String[] args) {

        P4HowSum obj = new P4HowSum();
        int[] nums = {7, 14};
        int target = 900;
        List<Integer> res;

        Boolean dp[] = new Boolean[target + 1];
        Arrays.fill(dp, null);
        res = new ArrayList<>();
        obj.howSumDP(nums, target, dp, res);
        System.out.println(res);

        res = new ArrayList<>();
        obj.howSumRecur(nums, target, res);
        System.out.println(res);

        System.out.println(obj.howSumRecur2(nums, target));


    }

    boolean howSumRecur(int nums[], int target, List<Integer> ans) {
        if (target < 0)
            return false;

        if (target == 0)
            return true;

        for (int num : nums) {

            boolean res = howSumRecur(nums, target - num, ans);
            if (res) {
                ans.add(num);
                return true;
            }
        }

        return false;
    }

    List<Integer> howSumRecur2(int nums[], int target) {
        if (target < 0)
            return null;

        if (target == 0)
            return new ArrayList<>();

        for (int num : nums) {

            List<Integer> res = howSumRecur2(nums, target - num);
            if (res != null) {
                res.add(num);
                return res;
            }
        }

        return null;
    }

    boolean howSumDP(int[] nums, int target, Boolean[] memo, List<Integer> res) {

        if (target < 0)
            return false;

        if (target == 0)
            return true;

        if (memo[target] != null) {
            return memo[target];
        }

        for (int num : nums) {
            boolean interRes = howSumDP(nums, target - num, memo, res);
            memo[target] = interRes;
            if (interRes) {
                res.add(num);
                return true;
            }
        }
        return false;
    }
}
