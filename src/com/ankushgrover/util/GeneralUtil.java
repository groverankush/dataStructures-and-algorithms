package com.ankushgrover.util;

import java.util.Arrays;

public class GeneralUtil {

    public static void print2dArray(int [][] arr) {
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }
    }

}
