package com.ankushgrover.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 28/08/20
 */
public class P215LCM {

    public static void main(String[] args) {


        P215LCM obj = new P215LCM();


        int[][] arr = {{1, 4}, {2, 3}, {3, 4}};
        System.out.println(Arrays.toString(obj.findRightInterval(arr)));

    }

    public int[] findRightInterval(int[][] intervals) {

        List<Node> list = new ArrayList<>();

        int[] res = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {

            list.add(new Node(i, intervals[i]));

        }

        list.sort(new Comparator<Node>() {
            @Override
            public int compare(Node node, Node t1) {
                //if(node.arr[0] > t1.arr[0] && node.arr[1] <= t1.)
                return node.arr[0] - t1.arr[1];
            }
        });

        for (int i = 0; i < list.size(); i++) {
            System.out.println(Arrays.toString(list.get(i).arr));
        }

        for (int i = 0; i < list.size(); i++) {
            int value = i < list.size() - 1 ? list.get(i + 1).index : -1;
            res[list.get(i).index] = value;


        }

        return res;


    }

    class Node {

        int index;

        int[] arr;


        Node(int index, int[] arr) {
            this.index = index;
            this.arr = arr;
        }


    }
}
