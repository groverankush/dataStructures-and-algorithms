package com.ankushgrover.problems;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class P28RemoveDuplicates {

    public static void main(String[] args) {
        int[] arr = {2, 2, 3, 4, 4, 5};
        System.out.println(removeDuplicates(arr));
    }

    public static int removeDuplicates(int[] nums) {

        if (nums.length == 0)
            return 0;

        int last = nums[0], index = 1;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] != last) {
                nums[index++] = nums[i];
                last = nums[i];
            }

        }
        return index;
    }
}
