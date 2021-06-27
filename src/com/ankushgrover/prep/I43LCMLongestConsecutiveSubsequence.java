package com.ankushgrover.prep;

import java.util.HashMap;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 24/06/21
 * <p>
 * https://leetcode.com/problems/longest-consecutive-sequence/
 */
public class I43LCMLongestConsecutiveSubsequence {

    public static void main(String[] args) {

        I43LCMLongestConsecutiveSubsequence obj = new I43LCMLongestConsecutiveSubsequence();

        int nums[] = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};

        System.out.println(obj.longestConsecutive(nums));

    }

    public int longestConsecutive(int[] nums) {

        HashMap<Integer, Storage> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {

            int num = nums[i];


            Storage li = null;
            Storage gi = null;

            if (map.containsKey(num - 1)) {
                li = map.get(num - 1);
            }
            if (map.containsKey(num + 1)) {
                gi = map.get(num + 1);
            }
            int value = (li != null ? li.count : 0) + (gi != null ? gi.count : 0) + 1;

            if (li != null) {
                li.count = value;
                //map.put(num-1, value);
            }
            if (gi != null) {
                gi.count = value;
                //map.put(num+1, value);
            }


            Storage st;

            if (li == null && gi == null) {
                st = new Storage(value);
            } else if (li == null) {
                st = gi;
            } else st = li;

            map.put(num, st);


            max = Math.max(max, value);

        }

        return max;

    }

    class Storage {
        int count;

        Storage(int count) {
            this.count = count;
        }
    }
}
