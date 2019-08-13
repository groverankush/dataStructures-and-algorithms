package com.ankushgrover.problems;

import java.util.Arrays;

/**
 * Hi, here's your problem today. This problem was recently asked by Facebook:
 * <p>
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * Example:
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 * <p>
 * Here is a starting point:
 * <p>
 * class Solution:
 * def moveZeros(self, nums):
 * # Fill this in.
 * <p>
 * nums = [0, 0, 0, 2, 0, 1, 3, 4, 0, 0]
 * Solution().moveZeros(nums)
 * print(nums)
 * # [2, 1, 3, 4, 0, 0, 0, 0, 0, 0]
 */
public class P42MoveZeroes {

    public static void main(String[] args) {

        int[] nums = {4, 0, 0, 0, 0, 0, 0, 8, 0, 0, 0, 6};
        System.out.println(Arrays.toString(nums));
        move(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void move(int[] nums) {

        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[start];
                nums[start++] = temp;
            }
        }

    }
}
