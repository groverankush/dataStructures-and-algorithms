package com.ankushgrover.contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 01/09/19
 */
public class C04 {

    public static void main(String[] args) {




        int [] arr = {3,6,5,4,11,10};
        int k = 1, lower = 0, upper = 5;

        //System.out.println(dietPlanPerformance(arr, k , lower, upper)) ;

        String s = "abcda";
        int [][] queries = {{3,3,0},{1,2,0},{0,3,1},{0,3,2},{0,4,1}};
        System.out.println(canMakePaliQueries(s, queries));


    }

    /**
     * 174. Diet Plan Performance
     * User Accepted: 18
     * User Tried: 23
     * Total Accepted: 18
     * Total Submissions: 24
     * Difficulty: Easy
     * A dieter consumes calories[i] calories on the i-th day.  For every consecutive sequence of k days, they look at T, the total calories consumed during that sequence of k days:
     * <p>
     * If T < lower, they performed poorly on their diet and lose 1 point;
     * If T > upper, they performed well on their diet and gain 1 point;
     * Otherwise, they performed normally and there is no change in points.
     * Return the total number of points the dieter has after all calories.length days.
     * <p>
     * Note that: The total points could be negative.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: calories = [1,2,3,4,5], k = 1, lower = 3, upper = 3
     * Output: 0
     * Explaination: calories[0], calories[1] < lower and calories[3], calories[4] > upper, total points = 0.
     * Example 2:
     * <p>
     * Input: calories = [3,2], k = 2, lower = 0, upper = 1
     * Output: 1
     * Explaination: calories[0] + calories[1] > upper, total points = 1.
     * Example 3:
     * <p>
     * Input: calories = [6,5,0,0], k = 2, lower = 1, upper = 5
     * Output: 0
     * Explaination: calories[0] + calories[1] > upper, calories[2] + calories[3] < lower, total points = 0.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= k <= calories.length <= 10^5
     * 0 <= calories[i] <= 20000
     * 0 <= lower <= upper
     *
     * @param calories
     * @param k
     * @param lower
     * @param upper
     * @return
     */

    private static int dietPlanPerformance(int[] calories, int k, int lower, int upper) {

        int sum = 0;
        int result = 0;

        for(int i = 0 ; i  < k; i++){
            sum+= calories[i];
        }

        if(sum < lower)
            result--;
        else if(sum > upper)
            result++;

        for(int i = k; i < calories.length; i++){
            sum += calories[i];
            sum -= calories[i - k];

            if(sum < lower)
                result--;
            else if(sum > upper)
                result++;

        }

        return result;
    }

    /**
     * https://leetcode.com/problems/can-make-palindrome-from-substring/
     * @param s
     * @param queries
     * @return
     */
    private static List<Boolean> canMakePaliQueries(String s, int[][] queries) {

        List<Boolean> list = new ArrayList<>();

        for(int i  = 0 ; i < queries.length; i++){

            int [] arr = queries[i];

            if(arr[2] >= 13){
                list.add(true);
                continue;
            }


            String sub = s.substring(arr[0], arr[1] + 1);

            byte [] map = new byte[26];
            int count = 0;
            for(int j = 0 ; j < sub.length(); j++){
                int index = sub.charAt(j) - 'a';

                if(map[index] == 1){
                    count--;
                    map[index] = 0;
                }
                else{
                    map[index] = 1;
                    count++;
                }
            }

            list.add(count/2 <= arr[2]);

        }

        return list;

    }
}
