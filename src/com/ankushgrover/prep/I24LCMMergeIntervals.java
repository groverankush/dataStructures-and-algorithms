package com.ankushgrover.prep;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 13/05/21
 */
public class I24LCMMergeIntervals {

    public static void main(String[] args) {
        I24LCMMergeIntervals obj = new I24LCMMergeIntervals();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        obj.merge(intervals);
    }

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(ints -> ints[0]));

        LinkedList<int[]> arrs = new LinkedList<>();

        int[] reference = null;


        for (int i = 0; i < intervals.length; i++) {

            if (arrs.isEmpty() || arrs.getLast()[1] < intervals[i][0]) {
                arrs.add(intervals[i]);
            } else {
                arrs.getLast()[1] = Math.max(arrs.getLast()[1], intervals[i][1]);
            }
        }
        return arrs.toArray(new int[arrs.size()][2]);
    }
}
