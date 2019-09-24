package com.ankushgrover.dataStructures.graph.shortestDistance;

import java.util.Arrays;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 24/09/19
 */
public class BellmanFord {

    public static void main(String[] args) {


        BellmanFord algo = new BellmanFord();
        // to - from - edge weight
        int[][] edges = {{1, 2, 6}, {2, 1, 9}, {1, 4, 5}, {4, 3, 2}, {4, 2, 8}, {3, 2, 36}};
        System.out.println(Arrays.toString(algo.shortestDistance(4, edges)));


    }

    private int[] shortestDistance(int vertices, int[][] edges) {

        int[] res = new int[vertices];

        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = 0;

        for (int i = 0; i < edges.length; i++) {

            for (int j = 0; j < edges.length; j++) {
                int[] edge = edges[j];
                res[edge[1] - 1] = Math.min(res[edge[0] - 1] + edge[2], res[edge[1] - 1]);
            }

        }

        return res;

    }
}
