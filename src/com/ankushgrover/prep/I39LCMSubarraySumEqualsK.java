package com.ankushgrover.prep;

import java.util.HashMap;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 12/06/21
 */
public class I39LCMSubarraySumEqualsK {

    public static void main(String[] args) {

        I39LCMSubarraySumEqualsK obj = new I39LCMSubarraySumEqualsK();
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println(obj.subarraySum(nums, k));

    }

    public int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int res = 0;

        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            map.put(sum, map.getOrDefault(sum, 0) + 1);

            res += map.getOrDefault(sum - k, 0);

        }

        return res;

    }
}
