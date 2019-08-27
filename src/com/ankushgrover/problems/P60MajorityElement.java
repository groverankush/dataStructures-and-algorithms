package com.ankushgrover.problems;

import java.util.HashMap;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 27/08/19
 *
 * https://leetcode.com/problems/majority-element/
 */
public class P60MajorityElement {

    public static void main(String[] args) {

        int [] nums = {1,1,2,2,2,2,2,3,4,5};

        System.out.println(majorityElementHash(nums));

    }



    /**
     * Boyer-Moore Voting Algorithm
     *
     * Explanation: http://www.cs.utexas.edu/~moore/best-ideas/mjrty/example.html#step01
     *
     * Check solutions as well: https://leetcode.com/problems/majority-element/solution/
     *
     * @param nums
     * @return
     */
    private static int majorityElementBM(int[] nums) {

        int count = 0;
        int candidate = nums[0];

        for(int i = 0 ; i < nums.length; i++){
            if(count == 0)
                candidate = nums[i];

            count += (nums[i] == candidate) ? 1 : -1;

        }

        return candidate;
    }

    private static int majorityElementHash(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int key : map.keySet()){
            if(map.get(key) > (nums.length / 2))
                return key;
        }

        return -1;
    }
}
