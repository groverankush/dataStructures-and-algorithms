package com.ankushgrover.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 04/09/19
 * <p>
 * https://leetcode.com/problems/merge-intervals/
 */
public class P77MergeIntervals {

    public static void main(String[] args) {

        int[][] intervals = {{1, 4}, {4, 5}};

        int[][] arr = merge(intervals);

        System.out.println(Arrays.toString(arr));
    }

    private static int[][] merge(int[][] intervals) {

        if (intervals.length == 0) {
            return new int[0][0];
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return t1[0] - t2[0];
            }
        });

        int start = intervals[0][0], end = intervals[0][1];
        List<int[]> list = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            } else {
                int[] arr = {start, end};
                list.add(arr);

                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        int[] arr = {start, end};
        list.add(arr);

        int[][] r = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            r[i] = list.get(i);
        }


        return r;

    }
}
