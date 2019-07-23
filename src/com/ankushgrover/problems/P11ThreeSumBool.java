package com.ankushgrover.problems;

import java.util.Arrays;
import java.util.HashSet;

public class P11ThreeSumBool {

    public static void main(String[] args) {

        int[] arr = { 1, 4, 45, 6, 10, 8 };
        System.out.println(threeSum(arr, 56));

    }

    private static boolean threeSum(int[] arr, int target) {

        Arrays.sort(arr);

        for(int i = 0 ; i < arr.length-2; i++){

            int start = i+1;
            int end = arr.length-1;

            int subTarget = target - arr[i];

            while(start < end){
                int sum = arr[start] + arr[end];
                if(sum == subTarget){
                    System.out.println(String.format("[%d, %d, %d]", arr[i], arr[start], arr[end]));
                    return true;
                }


                if(sum < subTarget)
                    start++;
                else end--;
            }

        }
        return false;
    }
}
