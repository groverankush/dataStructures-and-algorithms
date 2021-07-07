package com.ankushgrover.prep;

import java.util.*;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 28/06/21
 */
public class I45LCMSlidingWindowMaximum {

    public I45LCMSlidingWindowMaximum() {
    }

    public static void main(String[] args) {

        I45LCMSlidingWindowMaximum obj = new I45LCMSlidingWindowMaximum();
        int nums[] = {1, 3, 1, 2, 0, 5};
        int k = 3;
        System.out.println(Arrays.toString(obj.maxSlidingWindow(nums, k)));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        //return priorityQueueApproach(nums, k); // Time Limit exceeded


        return null;
    }

    private int[] treeMapApproach(int nums[], int k) {

        LinkedList<Container> list = new LinkedList<>();

        HashMap<Integer, Integer> map;
        //map.remove()
        //list.remove(0)

        return null;

    }

    private int[] priorityQueueApproach(int nums[], int k) {

        int end = k - 1;
        int start = 0;

        ArrayList<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int i = 0; i < end; i++) {
            q.add(nums[i]);
        }

        while (end < nums.length) {
            q.add(nums[end]);

            list.add(q.peek());

            q.remove(nums[start]);

            start++;
            end++;

        }

        int[] res = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;

    }

    class Container {
    }
}
