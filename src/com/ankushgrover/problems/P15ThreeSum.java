package com.ankushgrover.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode.com/problems/3sum/
 */
public class P15ThreeSum {

    public static void main(String[] args) {

        int [] nums = {-2,0,1,1,2};

        System.out.println(threeSum(nums));
    }

    private static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        HashSet<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[start] + nums[end];
                if (sum == (0 - nums[i])) {
                    ArrayList<Integer> list = new ArrayList<>();

                    list.add(nums[i]);
                    list.add(nums[start]);
                    list.add(nums[end]);
                    set.add(list);
                }
                if (sum < (0 - nums[i]))
                    start++;
                else end--;
            }
        }

        return new ArrayList<>(set);

    }
}
