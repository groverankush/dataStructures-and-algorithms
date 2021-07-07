package com.ankushgrover.prep;

import java.util.HashMap;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 05/07/21
 */
public class I48LCMFruitsIntoBasket {

    public static void main(String[] args) {

        I48LCMFruitsIntoBasket obj = new I48LCMFruitsIntoBasket();
        int[] arr = {0, 1, 2, 2};
        System.out.println(obj.totalFruit(arr));

    }


    public int totalFruit(int[] fruits) {


        return approach1(fruits);
    }

    private int approach1(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int start = 0;
        int end = 0;

        int count = 0;
        int res = 0;

        while (end < nums.length) {

            System.out.println("start: " + start + " end : " + end);

            if ((map.containsKey(nums[end]) && map.size() <= 2) || (map.size() < 2)) {
                map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);
                end++;
                count++;
            } else {

                while (map.size() == 2) {
                    int tempCount = map.get(nums[start]);
                    if (tempCount == 1) {
                        map.remove(nums[start]);
                    } else {
                        map.put(nums[start], tempCount - 1);
                    }
                    count--;
                    start++;
                }
            }

            res = Math.max(res, count);

        }

        return res;

    }
}
