package com.ankushgrover.prep.byNitin;

import java.util.HashMap;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 23/06/21
 * <p>
 * https://leetcode.com/problems/contiguous-array/
 */
public class P02LCMContiguousArray {

    public static void main(String[] args) {
        P02LCMContiguousArray obj = new P02LCMContiguousArray();
        int nums[] = {1, 1, 1, 1, 0, 0, 0, 0, 0, 1};
        System.out.println(obj.findMaxLength(nums));
    }

    public int findMaxLength(int[] nums) {


        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] == 0 ? -1 : 1;
        }

        //return v1(nums);
        return v2(nums);

    }

    private int v2(int nums[]) {
        int sum = 0;
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];

            if (map.containsKey(sum)) {
                res = Math.max(res, i - map.get(sum));
            } else {
                map.put(sum, i);
            }

        }

        return res;
    }

    private int v1(int nums[]) {
        int sum = 0;
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];

            if (sum == 0) {
                res = Math.max(res, i + 1);
            } else {
                if (map.containsKey(sum)) {
                    res = Math.max(res, i - map.get(sum));
                }
                int index = map.getOrDefault(sum, -1);
                if (index == -1) {
                    map.put(sum, i);
                }
            }

        }

        return res;
    }
}
