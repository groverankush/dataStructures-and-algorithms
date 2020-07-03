package com.ankushgrover.problems;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 03/07/20
 * <p>
 * https://leetcode.com/problems/prison-cells-after-n-days/
 * <p>
 * #medium
 */
public class P180LCMPrisonCellsAfterNDays {

    public static void main(String[] args) {
    }

    public int[] prisonAfterNDays(int[] cells, int N) {


        HashSet<String> set = new HashSet<>();
        int count = 0;
        boolean cycleFound = false;
        for (int i = 0; i < N; i++) {

            int other[] = getNextDay(cells);
            String s = Arrays.toString(other);
            if (!set.contains(s)) {
                set.add(s);
                count++;
            } else {
                cycleFound = true;
                break;
            }


            cells = other;

        }

        if (cycleFound) {
            N = N % count;
            for (int i = 0; i < N; i++) {
                int other[] = getNextDay(cells);
                cells = other;
            }

        }

        return cells;
    }

    private int[] getNextDay(int cells[]) {
        int other[] = new int[cells.length];
        for (int j = 1; j < cells.length - 1; j++) {

            other[j] = cells[j - 1] == cells[j + 1] ? 1 : 0;

        }
        return other;
    }
}
