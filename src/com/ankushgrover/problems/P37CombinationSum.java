package com.ankushgrover.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P37CombinationSum {

    public static void main(String[] args) {

        int[] candidates = {2, 3, 6, 7};
        int target = 7;


        System.out.println(combinationSum(candidates, target));

    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();
        sum(candidates, target, list, inner, 0);
        return list;
    }

    private static void sum(int[] candidates, int target, List<List<Integer>> list, List<Integer> inner, int index) {

        if (target < 0)
            return;
        if (target == 0) {
            list.add(new ArrayList<>(inner));
        } else {
            for (int i = index; i < candidates.length; i++) {
                inner.add(candidates[i]);
                sum(candidates, target - candidates[i], list, inner, i);
                inner.remove(inner.size() - 1);
            }
        }
    }

}
