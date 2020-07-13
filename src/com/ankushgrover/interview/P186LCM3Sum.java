package com.ankushgrover.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 08/07/20
 * <p>
 * #medium
 */
public class P186LCM3Sum {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();

        list.add(3);

        System.out.println(list.toString());
        ;
    }

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);


        List<List<Integer>> result = new ArrayList<>();

        //HashMap<String, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int start = i + 1;
            int end = nums.length - 1;

            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];

                if (sum == 0) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[start]);
                    list.add(nums[end]);
                    //map.put(list.toString(),list);
                    result.add(list);

                    while (start < end && nums[start + 1] == nums[start])
                        start++;
                    while (start < end && nums[end - 1] == nums[end])
                        end--;

                    start++;
                    end--;
                } else if (sum < 0) {
                    start++;
                } else end--;

            }
        }

        /*for(String key : map.keySet()){
            result.add(map.get(key)) ;
        }*/
        return result;

    }
}
