package com.ankushgrover.problems;

import java.util.Arrays;
import java.util.HashSet;

/**
 * https://leetcode.com/problems/two-sum/
 */
public class P02TwoSum {

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(arr, 9)));
    }

    public static int[] twoSum(int[] nums, int target) {

        HashSet<Integer> set = new HashSet<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {

            int current = nums[i];
            int index = -1;

            if (set.contains(target - current)) {
                for (int j = 0; j < nums.length; j++) {

                    if (j != i && nums[j] == target - current) {
                        index = j;
                        break;
                    }

                }
                result[0] = i < index ? i : index;
                result[1] = i > index ? i : index;
            } else {
                set.add(current);
            }
        }

        return result;
    }
}
