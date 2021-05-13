package com.ankushgrover.prep;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 12/05/21
 */
public class I23LCMKthLargestElementInAnArray {

    public static void main(String[] args) {
    }

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return t1 - integer;
            }
        });

        for (int num : nums) {
            q.add(num);
        }

        for (int i = 0; i < k - 1; i++) {
            q.poll();
        }

        return q.poll();
    }

    private int[] arr() {
        return new int[]{1};
    }


}

