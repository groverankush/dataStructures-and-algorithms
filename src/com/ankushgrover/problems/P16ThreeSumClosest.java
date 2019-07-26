package com.ankushgrover.problems;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/3sum-closest/
 */
public class P16ThreeSumClosest {

    public static void main(String[] args) {

        int[] arr = {1, 1, 1, 1};
        System.out.println(threeSumClosest(arr, 4));
    }

    private static int threeSumClosest(int[] nums, int target) {

        boolean isSet = false;
        int ans = -1;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;

            while (start < end) {
                int temp = nums[i] + nums[start] + nums[end];
                if (!isSet) {
                    ans = temp;
                    isSet = true;
                } else {

                    if (Math.abs(ans - target) > Math.abs(temp - target))
                        ans = temp;
                }

                if (nums[start] + nums[end] < (target - nums[i]))
                    start++;
                else end--;

            }
        }

        return ans;
    }
}

