package com.ankushgrover.problems;

/**
 * https://leetcode.com/problems/search-insert-position/
 */
public class P35SearchInsertPosition {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 10};
        System.out.println(searchInsert(arr, 13));
    }

    private static int searchInsert(int[] nums, int target) {
        int i = 0;
        for (i = 0; i < nums.length; i++) {
            if (target == nums[i])
                return i;

            if (target < nums[i]) {
                return i == 0 ? 0 : i;
            }
        }
        return nums.length == i ? i : 0;
    }
}
