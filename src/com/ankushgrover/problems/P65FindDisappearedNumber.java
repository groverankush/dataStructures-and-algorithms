package com.ankushgrover.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 29/08/19
 */
public class P65FindDisappearedNumber {

    public static void main(String[] args) {

        int [] nums = {4,3,2,7,8,2,3,1};

        System.out.println(findDisappearedNumbers(nums));
        System.out.println(findDisappearedNumbersBetter(nums));

    }

    private static List<Integer> findDisappearedNumbers(int[] nums) {

        int arr [] = new int [nums.length];

        for(int i = 0 ; i < nums.length; i++){
            arr[nums[i] - 1] = nums[i];
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0 ; i <  arr.length; i++){
            if(arr[i] == 0)
                list.add(i+1);
        }

        return list;
    }

    private static List<Integer> findDisappearedNumbersBetter(int [] nums){

        List<Integer> list = new ArrayList<>();

        int index = 0;

        while(index < nums.length) {

            if (nums[index] == index + 1 || nums[index] == -1) {
                index++;
            } else {
                if (nums[nums[index] - 1] == nums[index]) {
                    nums[index] = -1;
                    index++;
                } else {
                    int temp = nums[nums[index] - 1];
                    nums[nums[index] - 1] = nums[index];
                    nums[index] = temp;
                }

            }
        }

        for(index = 0; index < nums.length; index++){

            if(nums[index] == -1)
                list.add(index+1);

        }

        return list;

    }
}
