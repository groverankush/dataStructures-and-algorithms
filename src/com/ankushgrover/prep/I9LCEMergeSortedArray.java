package com.ankushgrover.prep;

import java.util.Arrays;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 22/04/21
 */
public class I9LCEMergeSortedArray {

    public static void main(String[] args) {

        I9LCEMergeSortedArray obj = new I9LCEMergeSortedArray();
        int[] arr1 = {0, 0, 0, 0, 0};
        int[] arr2 = {1, 2, 3, 4, 5};
        obj.merge(arr1, 0, arr2, 5);
        System.out.println(Arrays.toString(arr1));

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if ((m == 1 && n == 0))
            return;


        if (m == 0 && n == 1) {
            nums1[nums1.length - 1] = nums2[0];
            return;
        }

        int i = m - 1, j = n - 1, index = nums1.length - 1;

        while (index >= 0) {

            if (i >= 0 && j >= 0) {

                if (nums1[i] >= nums2[j]) {
                    nums1[index--] = nums1[i--];
                } else {
                    nums1[index--] = nums2[j--];
                }

            } else {

                if (i >= 0) {
                    nums1[index--] = nums1[i--];
                }

                if (j >= 0) {
                    nums1[index--] = nums2[j--];
                }

            }
        }
    }
}
