package com.ankushgrover.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 13/06/20
 */
public class P170LCMLargestDivisibleSubset {

    public static void main(String[] args) {

        P170LCMLargestDivisibleSubset obj = new P170LCMLargestDivisibleSubset();
        int nums[] = {1, 2, 4, 8};
        System.out.println(obj.largestDivisibleSubset(nums));
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {

        if (nums.length == 0)
            return new ArrayList<>();

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        ArrayList<Integer> l = new ArrayList<>();
        l.add(nums[0]);
        map.put(nums[0], l);
        int max = 1;
        int key = nums[0];

        for (int i = 1; i < nums.length; i++) {

            boolean flag = true;

            for (int j = i - 1; j >= 0; j--) {

                if (nums[i] % nums[j] == 0) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.addAll(map.get(nums[j]));
                    map.put(nums[i], list);
                    if (list.size() > max) {
                        max = list.size();
                        key = nums[i];
                    }
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(nums[i]);
                map.put(nums[i], temp);
            }

        }

        return map.get(key);

    }
}
