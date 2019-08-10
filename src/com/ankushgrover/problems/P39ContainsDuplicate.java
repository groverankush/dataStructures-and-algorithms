package com.ankushgrover.problems;

import java.util.HashSet;

/**
 * https://leetcode.com/problems/contains-duplicate/
 */
public class P39ContainsDuplicate {

    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 4, 5, 6};
        System.out.println(containsDuplicate(nums));
    }

    private static boolean containsDuplicate(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num))
                return true;
            set.add(num);
        }

        return false;

    }
}
