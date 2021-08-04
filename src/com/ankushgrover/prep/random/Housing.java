package com.ankushgrover.prep.random;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 08/07/21
 */
public class Housing {


    /**
     * Smallest subarray with sum greater than a given value.. Examples:
     * arr[] = {1, 4, 45, 6, 0, 19}
     * x  =  51
     * Output: 3
     * Minimum length subarray is {4, 45, 6}
     * <p>
     * arr[] = {1, 10, 5, 2, 7}
     * x  = 9
     * Output: 1
     * Minimum length subarray is {10}
     * <p>
     * arr[] = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250}
     * x = 280
     * Output: 4
     * Minimum length subarray is {100, 1, 0, 200}
     * <p>
     * arr[] = {1, 2, 4}
     * x = 8
     * Output : Not Possible
     * Whole array sum is smaller than 8.
     */

    public static void main(String[] args) {
        Housing obj = new Housing();
        int arr[] = {1, 2, 4};
        int target = 8;
        System.out.println(obj.smallestSubArrayLength(arr, target));
    }

    private int smallestSubArrayLength(int[] arr, int target) {


        int res = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int sum = 0;

        while (start < arr.length) {

            if (sum <= target && end < arr.length) {
                sum += arr[end];
                end++;
            } else {

                if (sum > target) {
                    res = Math.min(res, end - start);
                }

                sum -= arr[start];
                start++;

            }

        }

        return res == Integer.MAX_VALUE ? -1 : res;

    }
}
