package com.ankushgrover.problems;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 17/07/20
 */
public class P192LCMTopKFrequentElements {

    public static void main(String[] args) {
    }


    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Node> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            Node node = map.getOrDefault(nums[i], null);
            if (node == null) {
                node = new Node(nums[i]);
                map.put(nums[i], node);
            }
            node.count++;
        }

        PriorityQueue<Node> queue = new PriorityQueue<>();

        for (int key : map.keySet()) {
            queue.add(map.get(key));
        }

        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = queue.poll().val;
        }

        return arr;
    }

    class Node implements Comparable<Node> {
        int val;
        int count;

        Node(int val) {
            this.val = val;
            this.count = 0;
        }

        @Override
        public int compareTo(Node node) {
            return node.count - count;

        }
    }
}
