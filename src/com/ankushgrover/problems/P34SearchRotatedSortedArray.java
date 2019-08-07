package com.ankushgrover.problems;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class P34SearchRotatedSortedArray {

    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 4, 5, 6};
        System.out.println(search(arr, 7));

    }

    public static int search(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;


        while (low <= high) {

            int mid = (low + high) / 2;

            if (nums[mid] == target)
                return mid;


            if (isLeft(nums, target, low, mid, high)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return -1;

    }

    public static boolean isLeft(int[] nums, int target, int start, int mid, int end) {
        if (nums[start] < nums[mid]) {
            return nums[start] <= target && target <= nums[mid];
        } else {
            return nums[end] > nums[mid] && !(target >= nums[mid] && target <= nums[end]);
        }
    }
}
