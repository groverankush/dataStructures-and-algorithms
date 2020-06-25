package com.ankushgrover.problems;

import java.util.HashSet;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 25/06/20
 */
public class P175LCMFindTheDuplicateNumber {

    public static void main(String[] args) {
    }

    public int findDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num))
                return num;
            set.add(num);
        }
        return -1;
    }
}
