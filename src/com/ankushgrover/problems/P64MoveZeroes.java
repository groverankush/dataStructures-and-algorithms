package com.ankushgrover.problems;

import java.util.Arrays;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 28/08/19
 *
 * https://leetcode.com/problems/move-zeroes/
 */
public class P64MoveZeroes {

    public static void main(String[] args) {

        int [] nums= {1,2,3,0,0,2,3,0,4};

        moveZeroes(nums);

        System.out.println(Arrays.toString(nums));

    }

    private static void moveZeroes(int[] nums) {

        int index = -1;

        int i = 0;
        while(i < nums.length){
            if(nums[i]==0 && index == -1)
                index = i;
            else if(nums[i] != 0 && index != -1){
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                index++;
            }
            i++;
        }

    }
}
