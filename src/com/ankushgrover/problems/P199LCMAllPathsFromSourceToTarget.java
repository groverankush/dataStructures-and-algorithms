package com.ankushgrover.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 25/07/20
 * <p>
 * https://leetcode.com/problems/all-paths-from-source-to-target/
 * <p>
 * #medium
 */
public class P199LCMAllPathsFromSourceToTarget {

    public static void main(String[] args) {
        P199LCMAllPathsFromSourceToTarget obj = new P199LCMAllPathsFromSourceToTarget();
        int graph[][] = {{1, 2}, {3}, {3}, {}};
        obj.allPathsSourceTarget(graph);

    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int mod[][] = new int[graph.length][graph.length];

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                mod[i][graph[i][j]] = 1;
            }
        }

        LinkedList<List<Integer>> list = new LinkedList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(mod.length - 1);
        list.add(temp);

        List<List<Integer>> result = new ArrayList<>();
        while (!list.isEmpty()) {
            List<Integer> inter = list.poll();
            int ref = inter.get(0);
            for (int i = 0; i < mod.length; i++) {
                if (mod[i][ref] == 1) {
                    List<Integer> toAdd = new ArrayList<Integer>(inter);
                    toAdd.add(0, i);
                    if (i == 0) {
                        result.add(toAdd);
                    } else {
                        list.add(toAdd);
                    }
                }
            }
        }

        return result;
    }
}
