package com.ankushgrover.prep;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 11/05/21
 * <p>
 * https://leetcode.com/problems/permutations/
 */
public class I20LCMPermutations {

    public static void main(String[] args) {
        I20LCMPermutations obj = new I20LCMPermutations();
        int[] nums = {1, 2, 3};
        obj.permute(nums);
    }

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        List<Integer> numsList = new ArrayList<>();

        for (int num : nums) {
            numsList.add(num);
        }

        generate(numsList, list, ans);

        return ans;

    }

    private void generate(List<Integer> nums, List<Integer> list, List<List<Integer>> ans) {

        if (nums.size() == 0) {
            List<Integer> temp = new ArrayList<>(list);
            ans.add(temp);
            return;
        }

        List<Integer> copyOfNums = new ArrayList<>(nums);

        for (int i = 0; i < nums.size(); i++) {

            int num = copyOfNums.remove(i);
            list.add(num);

            generate(copyOfNums, list, ans);

            list.remove(list.size() - 1);
            copyOfNums.add(i, num);

        }

    }
}
