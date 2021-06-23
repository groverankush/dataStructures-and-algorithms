package com.ankushgrover.prep;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 22/06/21
 * https://leetcode.com/problems/first-missing-positive/
 */
public class I42LCHFirstMissingPositive {

    public static void main(String[] args) {

        I42LCHFirstMissingPositive obj = new I42LCHFirstMissingPositive();
        int nums[] = {1, 2, 3};
        obj.firstMissingPositive(nums);

    }

    public int firstMissingPositive(int[] nums) {

        int min = Integer.MAX_VALUE;


        for (int i = 0; i < nums.length; i++) {

            int num = nums[i];

            if (num > 0 && num < min) {
                min = nums[i];
            }

            if (num < 0) {
                nums[i] = 0;
            }

        }

        if (min > 1)
            return 1;

        int index = 0;
        for (int i = 0; i < nums.length; i++) {

            int cycleElement = nums[i] - 1;


            while (cycleElement >= 0 && cycleElement < nums.length) {

                int temp = nums[cycleElement];
                nums[cycleElement] = -1;
                cycleElement = temp - 1;

            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                index = i;
                break;
            }
        }

        return index + 1;

    }
}
