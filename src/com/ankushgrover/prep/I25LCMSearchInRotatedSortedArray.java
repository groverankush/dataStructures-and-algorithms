package com.ankushgrover.prep;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 13/05/21
 */
public class I25LCMSearchInRotatedSortedArray {

    public static void main(String[] args) {

        I25LCMSearchInRotatedSortedArray obj = new I25LCMSearchInRotatedSortedArray();
        int[] arr = {1, 3};
        obj.search(arr, 3);
    }


    public int search(int[] nums, int target) {

        return bSearch(nums, target, 0, nums.length - 1);

    }

    private int bSearch(int[] nums, int target, int start, int end) {

        if (start > end) {
            return -1;
        }

        //System.out.println("Start: " + start + " end: " + end);

        int mid = (start + end) / 2;
        int element = nums[mid];

        if (element == target)
            return mid;

        boolean isRightFine = element <= nums[end];

        if ((target >= nums[start] && (mid > 0 && mid < end) && target <= nums[mid - 1]) || isRightFine) {
            return bSearch(nums, target, start, mid - 1);
        } else {
            return bSearch(nums, target, mid + 1, end);
        }

    }
}
