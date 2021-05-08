package com.ankushgrover.prep;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 04/05/21
 */
public class I15LCMMissingRanges {

    private int a = 9;

    public static void main(String[] args) {

        I15LCMMissingRanges obj = new I15LCMMissingRanges();

        List<Integer> list = new LinkedList<>();


        LinkedList<Integer> l = (LinkedList) list;

        int nums[] = {2, 5};
        int lower = 0;
        int upper = 7;

        System.out.println(obj.findMissingRanges(nums, lower, upper));

    }

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {

        int start = nums[0];
        ArrayList<String> res = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {

            int diff = nums[i] - start;

            if (diff == 2) {
                res.add(String.valueOf(start + 1));
            } else if (diff > 2) {
                String builder = (start + 1) + "->" + (nums[i] - 1);
                res.add(builder);
            }

            start = nums[i];
        }

        if (lower != nums[0]) {
            start = lower;
            int end = nums[0] - 1;
            if (start == end) {
                res.add("" + start);
            } else {
                String builder = (lower) + "->" + (end);
                res.add(builder);
            }

        }

        if (upper != nums[nums.length - 1]) {
            String builder = (nums[nums.length - 1] + 1) + "->" + (upper);
            res.add(builder);
        }

        return res;
    }


}
