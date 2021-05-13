package com.ankushgrover.prep;

import java.util.*;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 12/05/21
 * <p>
 * https://leetcode.com/problems/top-k-frequent-elements/
 */
public class I22LCMTopKFrequentElements {

    public static void main(String[] args) {
    }

    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Holder> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            Holder holder = map.getOrDefault(num, null);
            if (holder == null) {
                holder = new Holder(num, 0);
                map.put(num, holder);
            }
            holder.count++;
        }
        int[] res = new int[k];

        Collection<Holder> values = map.values();

        List<Holder> list = new ArrayList<>(values);
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {

            res[i] = list.get(i).count;

        }


        return res;
    }

    class Holder implements Comparable<Holder> {
        int key;
        int count;

        public Holder(int key, int count) {
            this.key = key;
            this.count = count;
        }

        @Override
        public int compareTo(Holder o) {
            return o.count - this.count;
        }
    }
}
