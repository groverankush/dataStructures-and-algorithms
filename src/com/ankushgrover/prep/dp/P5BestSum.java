package com.ankushgrover.prep.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 16/05/21
 */
public class P5BestSum {

    public static void main(String[] args) {

        P5BestSum obj = new P5BestSum();

        int[] nums = new int[]{5, 3, 4, 7};
        int target = 7;
        System.out.println(obj.bestSum(nums, target));


        nums = new int[]{2, 3, 5};
        target = 8;
        System.out.println(obj.bestSum(nums, target));

        nums = new int[]{1, 4, 5};
        target = 8;
        System.out.println(obj.bestSum(nums, target));

        nums = new int[]{1, 2, 5, 25};
        target = 100;
        //System.out.println(obj.bestSum(nums, target));
        HashMap<Integer, List<Integer>> memo = new HashMap<>();
        List<Integer> ans = obj.bestSumDP(nums, target, memo);
        System.out.println("Memoised " + ans);


    }

    List<Integer> bestSum(int[] nums, int target) {

        if (target < 0)
            return null;

        if (target == 0)
            return new ArrayList<>();

        List<Integer> shortestCombination = null;
        for (int num : nums) {

            List<Integer> combination = bestSum(nums, target - num);
            if (combination != null) {
                combination.add(num);
                if (shortestCombination == null || combination.size() < shortestCombination.size()) {
                    shortestCombination = combination;
                }
            }

        }
        return shortestCombination;

    }

    List<Integer> bestSumDP(int[] nums, int target, HashMap<Integer, List<Integer>> memo) {

        if (target < 0)
            return null;

        if (target == 0)
            return new ArrayList<>();

        if (memo.containsKey(target))
            return memo.get(target);

        List<Integer> shortestCombination = null;
        for (int num : nums) {

            List<Integer> combination = bestSumDP(nums, target - num, memo);
            if (combination != null) {
                List<Integer> combi = new ArrayList<Integer>(combination);
                combi.add(num);
                if (shortestCombination == null || combi.size() < shortestCombination.size()) {
                    shortestCombination = combi;
                }
            }

        }
        memo.put(target, shortestCombination);

        return shortestCombination;

    }
}
