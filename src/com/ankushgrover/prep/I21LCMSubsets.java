package com.ankushgrover.prep;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 11/05/21
 */
public class I21LCMSubsets {

    public static void main(String[] args) {
    }

    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<Integer>());


            //generate(nums, res);
            generateRecursive(nums, 0, new ArrayList<>(), res);

            return res;
        }


        private void generateRecursive(int[] nums, int currentIndex, List<Integer> list, List<List<Integer>> res) {

            res.add(new ArrayList<Integer>(list));

            for (int i = 0; i < nums.length; i++) {

                list.add(nums[i]);
                generateRecursive(nums, currentIndex + 1, list, res);
                list.remove(list.size() - 1);


            }

        }

        private void generate(int[] nums, List<List<Integer>> res) {

            if (nums.length == 0)
                return;

            for (int i = 0; i < nums.length; i++) {

                int size = res.size();

                for (int j = 0; j < size; j++) {

                    List<Integer> temp = new ArrayList<>(res.get(j));
                    temp.add(nums[i]);
                    res.add(temp);

                }
            }
        }

    }
}
