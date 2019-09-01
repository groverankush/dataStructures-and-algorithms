package com.ankushgrover.problems;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 01/09/19
 *
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
 */
public class P69ShortestUnsortedContinuousSubarray {

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(findUnsortedSubarray(nums));
    }

    private static int findUnsortedSubarray(int[] nums) {

        int start = -1, end = 0, i = 0;

        for (i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                start = i;
                break;
            }
        }

        if (start == -1)
            return 0;

        for ( i = nums.length - 1; i > start; i--) {
            if (nums[i] < nums[i - 1]) {
                end = i;
                break;
            }
        }

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (i = start; i <= end; i++) {
            min = Math.min(nums[i], min);
            max = Math.max(nums[i], max);
        }

        for ( i = 0; i < start; i++) {
            if (nums[i] > min) {
                start = i;
                break;
            }
        }

        for ( i = nums.length - 1; i > end; i--) {
            if (nums[i] < max) {
                end = i;
                break;
            }
        }

        return end - start + 1;
    }
}
