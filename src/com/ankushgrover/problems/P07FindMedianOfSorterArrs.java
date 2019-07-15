package com.ankushgrover.problems;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 */
public class P07FindMedianOfSorterArrs {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {4, 5, 6};
        System.out.println(findMedianSortedArrays(arr1, arr2));
    }

    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length + nums2.length];
        int i = 0, j = 0, index = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j])
                arr[index] = nums1[i++];
            else arr[index] = nums2[j++];
            index++;
        }


        while (i < nums1.length) {
            arr[index++] = nums1[i++];
        }
        while (j < nums2.length) {
            arr[index++] = nums2[j++];
        }

        if (arr.length % 2 == 0) {
            double m = (arr.length + 1) / 2.0;
            return (arr[((int) Math.floor(m)) - 1] + arr[((int) Math.ceil(m)) - 1]) / 2.0;
        } else {
            return arr[((arr.length + 1) / 2) - 1];
        }

    }
}
