package com.ankushgrover.problems;

import java.util.*;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 22/09/19
 */
public class P125LCEasyMinimumAbsoluteDifference {

    public static void main(String[] args) {
        P125LCEasyMinimumAbsoluteDifference obj = new P125LCEasyMinimumAbsoluteDifference();
        int[] arr = {1, 2, 3, 4, 5};
        obj.minimumAbsDifference(arr);
    }

    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        Arrays.sort(arr);

        List<List<Integer>> result = new ArrayList<>();


        int diff = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - 1; i++) {
            if (diff > arr[i + 1] - arr[i]) {
                diff = arr[i + 1] - arr[i];
            }
        }

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] == diff) {
                List<Integer> list = new ArrayList<>();
                list.add(arr[i]);
                list.add(arr[i + 1]);
                result.add(list);
            }
        }

        return result;

    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        for (int i = 0; i < pairs.size(); i++) {

            List<Integer> pair = pairs.get(i);

            if (pair.get(0).equals(pair.get(i)))
                continue;

            HashSet<Integer> set = map.getOrDefault(pair.get(0), new HashSet<Integer>());
            set.add(pair.get(1));

        }

        char arr[] = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {

            HashSet<Integer> set = map.getOrDefault(i, null);
            if (set == null)
                continue;

            for (int key : set) {
            }
        }

        return "";
    }
}
