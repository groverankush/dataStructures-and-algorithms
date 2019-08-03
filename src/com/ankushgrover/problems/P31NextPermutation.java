package com.ankushgrover.problems;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/next-permutation/
 *
 * https://www.nayuki.io/page/next-lexicographical-permutation-algorithm
 */
public class P31NextPermutation {

    public static void main(String[] args) {
        int [] nums = {0,1,2,5,3,3,0};
        nextPermutation(nums);

        System.out.println(Arrays.toString(nums)) ;
    }

    private static void nextPermutation(int[] nums) {
        boolean flag = true;

        for(int i = 0; i < nums.length-1; i++){
            if(nums[i] < nums[i+1]){
                flag =false;
                break;
            }
        }

        if(flag){
            reverse(nums, 0);
        }else{
            int pivot = findPivot(nums);
            replaceWithMin(nums, pivot);
            reverse(nums, pivot+1);
        }
    }

    private static void replaceWithMin(int [] nums, int pivot){
        int index = -1;
        int temp = Integer.MAX_VALUE;
        for(int i = pivot+1; i < nums.length;i++){
            if(nums[i] <= temp && nums[i] > nums[pivot]){
                temp = nums[i];
                index = i;
            }
        }

        temp = nums[index];
        nums[index] = nums[pivot];
        nums[pivot] = temp;
    }

    private static int findPivot(int [] nums){
        for(int i = nums.length-1; i > 0; i-- ){
            if(nums[i-1] < nums[i])
                return i-1;
        }
        return -1;
    }

    private static void reverse(int [] nums, int start){
        int end = nums.length -1;
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
