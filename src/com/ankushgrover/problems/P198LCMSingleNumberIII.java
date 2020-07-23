package com.ankushgrover.problems;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 23/07/20
 * <p>
 * https://leetcode.com/problems/single-number-iii/
 * <p>
 * #medium
 */
public class P198LCMSingleNumberIII {

    public static void main(String[] args) {
    }

    public int[] singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }

        int arr[] = new int[2];

        Iterator<Integer> iter = set.iterator();
        for (int i = 0; i < 2; i++) {
            arr[i] = iter.next();
        }

        return arr;
    }
}
