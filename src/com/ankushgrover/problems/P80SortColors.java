package com.ankushgrover.problems;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 06/09/19
 * <p>
 * https://leetcode.com/problems/sort-colors/
 */
public class P80SortColors {


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


}
