package com.ankushgrover.problems;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 10/06/20
 * <p>
 * #easy #binarySearch
 */
public class P169LCESearchInsertPosition {

    public static void main(String[] args) {
    }

    public int searchInsert(int[] nums, int target) {

        int start = 0;
        int end = nums.length;

        while (start < end) {
            int mid = start + ((end - start) / 2);

            if (nums[mid] == target)
                return mid;
            if (nums[mid] < target && (mid + 1 >= nums.length || (mid + 1 < nums.length && nums[mid + 1] > target)))
                return mid + 1;
            if (nums[mid] > target && (mid - 1 < 0 || nums[mid - 1] < target))
                return mid;
            if (target < nums[mid]) {
                end = mid;
            } else if (target > nums[mid]) {
                start = mid;
            }
        }

        return -1;

    }
}
