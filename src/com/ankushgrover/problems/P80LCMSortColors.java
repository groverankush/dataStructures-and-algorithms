package com.ankushgrover.problems;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 06/09/19
 * <p>
 * https://leetcode.com/problems/sort-colors/
 *
 * #medium
 */
public class P80LCMSortColors {


    public static void main(String[] args) {
    }

    public void sortColors(int[] nums) {

        int i = 0;
        int z = 0;
        int t = nums.length - 1;

        while (i <= t) {

            switch (nums[i]) {

                case 0:
                    nums[i] = nums[z];
                    nums[z] = 0;
                    i++;
                    z++;
                    break;


                case 2:
                    nums[i] = nums[t];
                    nums[t] = 2;
                    t--;
                    break;

                case 1:
                    i++;
                    break;

            }

        }

    }

    public void sortColors1(int[] nums) {

        int start = 0;
        int end = nums.length - 1;
        int i = 0;


        while (i <= end) {
            if (nums[i] == 0) {
                if (nums[start] == 0) {
                    start++;
                    i++;
                } else {
                    int temp = nums[i];
                    nums[i] = nums[start];
                    nums[start] = temp;
                    start++;
                }
            } else if (nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[end];
                nums[end] = temp;
                end--;
            } else i++;

        }

    }

}
