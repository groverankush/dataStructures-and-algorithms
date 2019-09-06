package com.ankushgrover.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 06/09/19
 * <p>
 * https://leetcode.com/problems/subsets/
 */
public class P81Subsets {

    public static void main(String[] args) {
    }

    public List<List<Integer>> subsets(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        makeSubsets(result, temp, 0, nums);
        return result;


    }

    private void makeSubsets(List<List<Integer>> result, List<Integer> temp, int index, int[] nums) {

        result.add(new ArrayList<>(temp));

        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            makeSubsets(result, temp, i + 1, nums);
            temp.remove(temp.size() - 1);
        }

    }
}
