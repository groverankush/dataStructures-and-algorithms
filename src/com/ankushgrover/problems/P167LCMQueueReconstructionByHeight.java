package com.ankushgrover.problems;

import com.ankushgrover.util.GeneralUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 06/06/20
 * <p>
 * https://leetcode.com/problems/queue-reconstruction-by-height/
 * <p>
 * #medium #O(n^2)
 */
public class P167LCMQueueReconstructionByHeight {

    public static void main(String[] args) {
        P167LCMQueueReconstructionByHeight obj = new P167LCMQueueReconstructionByHeight();

        int[][] arr = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        GeneralUtil.print2dArray(obj.reconstructQueue(arr));


    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (ints, t1) -> {
            if (ints[0] == t1[0])
                return ints[1] - t1[1];
            return t1[0] - ints[0];
        });


        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            list.add(people[i][1], people[i]);
        }


        return list.toArray(people);
    }


}
