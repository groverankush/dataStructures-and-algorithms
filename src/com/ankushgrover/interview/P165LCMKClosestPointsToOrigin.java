package com.ankushgrover.interview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 05/06/20
 * <p>
 * https://leetcode.com/problems/k-closest-points-to-origin/
 *
 * #medium #sort #priorityQueue
 *
 */
public class P165LCMKClosestPointsToOrigin {

    public static void main(String[] args) {

        P165LCMKClosestPointsToOrigin obj = new P165LCMKClosestPointsToOrigin();

        int[][] arr = {{-5, 4}, {-6, -5}, {4, 6}};
        int[][] result = obj.kClosest1(arr, 2);

        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }

    // priorityQueue
    public int[][] kClosest1(int[][] points, int K) {


        PriorityQueue<Node> q = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node integer, Node t1) {

                return Double.compare(integer.distance, t1.distance);
            }
        });
        for (int i = 0; i < points.length; i++) {
            int[] t1 = points[i];
            q.add(new Node(i, Math.sqrt((t1[0] * t1[0]) + (t1[1] * t1[1]))));
        }
        // sqrt( (xa-xb)2 + (ya -yb)2 )

        int[][] result = new int[K][2];

        for (int i = 0; i < K; i++) {
            result[i] = points[q.poll().index];
        }

        return result;
    }

    //Sort
    public int[][] kClosest(int[][] points, int K) {

        Arrays.sort(points, (ints, t1) -> {
            double dist1 = Math.sqrt((ints[0] * ints[0]) + (ints[1] * ints[1]));
            double dist2 = Math.sqrt((t1[0] * t1[0]) + (t1[1] * t1[1]));

            return Double.compare(dist1, dist2);
        });
        int[][] result = new int[K][2];

        for (int i = 0; i < K; i++) {
            result[i] = points[i];
        }

        return result;

    }

    class Node {
        int index;
        double distance;

        Node(int index, double distance) {
            this.index = index;
            this.distance = distance;
        }
    }

    class MinHeap {

        void insert(double distance, int index) {
        }

        int getMin() {
            return 0;
        }
    }


}
