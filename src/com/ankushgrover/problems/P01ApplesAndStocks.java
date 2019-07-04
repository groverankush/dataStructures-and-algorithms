package com.ankushgrover.problems;

import java.util.ArrayList;

import static sun.swing.MenuItemLayoutHelper.max;

public class P01ApplesAndStocks {

    public static void main(String[] args) {
        int[] arr = {10, 7, 5, 8, 11, 9};
        System.out.println(applesAndStocks(arr));
    }

    private static int applesAndStocks(int[] arr) {


        int profit = 0;
        int index = 1;
        int prev = 0;
        while(index < arr.length){
            if(arr[index] - arr[prev] < profit ){
                prev++;
                index = prev+1;
            }else {
                profit = arr[index] - arr[prev];
                index++;
            }
        }

        return profit;
    }

}

