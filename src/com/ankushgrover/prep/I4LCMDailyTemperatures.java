package com.ankushgrover.prep;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 14/04/21
 * <p>
 * https://leetcode.com/problems/daily-temperatures/
 */
public class I4LCMDailyTemperatures {

    public static void main(String[] args) {

        I4LCMDailyTemperatures obj = new I4LCMDailyTemperatures();

        int arr[] = {73, 74, 75, 71, 69, 72, 76, 73};
        obj.dailyTemperatures(arr);

    }

    public int[] dailyTemperatures(int[] T) {
        int[] ref = new int[101];
        Arrays.fill(ref, Integer.MAX_VALUE);

        for (int i = T.length - 1; i >= 0; i--) {

            int min = Integer.MAX_VALUE;
            for (int j = T[i] + 1; j < ref.length; j++) {
                if (ref[j] < min) {
                    min = ref[j];
                }
            }

            ArrayList<Integer> list = new ArrayList<>();


            if (min < Integer.MAX_VALUE) {
                ref[T[i]] = i;
                T[i] = min - i;
            } else {
                ref[T[i]] = i;
                T[i] = 0;
            }
        }

        return T;
    }
}
