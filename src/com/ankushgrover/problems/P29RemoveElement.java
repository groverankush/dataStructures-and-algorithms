package com.ankushgrover.problems;

public class P29RemoveElement {

    public static void main(String[] args) {
        int arr[] = {3,2,2,3};
        int i = removeElement(arr, 3);

        for(int j = 0; j < i; j++){
            System.out.println(arr[j]);
        }
    }

    public static int removeElement(int[] nums, int val) {

        if(nums.length == 0)
            return 0;

        int index = 0;

        for(int i = 0; i < nums.length;i++){
            if(nums[i] != val){
                nums[index++] = nums[i];
            }
        }

        return index;
    }
}
