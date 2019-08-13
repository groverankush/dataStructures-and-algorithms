package com.ankushgrover.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/
 */
public class P43Permutations {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};


        System.out.println(permute(nums));
    }

    private static List<List<Integer>> permute(int[] nums) {

        if (nums == null || nums.length == 0) {
            List<List<Integer>> list = new ArrayList<>();
            list.add(new ArrayList<>());
            return list;
        }

        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        return permute(list);

    }

    private static List<List<Integer>> permute(List<Integer> nums) {

        if (nums.size() == 1) {
            List<List<Integer>> list = new ArrayList<>();
            list.add(nums);
            return list;
        }

        int first = nums.get(0);
        nums.remove(0);

        List<List<Integer>> permutations = permute(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < permutations.size(); i++) {

            for (int j = 0; j < permutations.get(i).size() + 1; j++) {
                List<Integer> temp = new ArrayList<>(permutations.get(i));
                temp.add(j, first);
                result.add(temp);
            }

        }

        return result;

    }
}
