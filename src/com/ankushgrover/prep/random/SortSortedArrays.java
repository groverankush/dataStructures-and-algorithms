package com.ankushgrover.prep.random;

import java.util.Arrays;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 15/06/21
 */
public class SortSortedArrays {

    public static void main(String[] args) {
        SortSortedArrays obj = new SortSortedArrays();


        int arr1[] = {100, 112, 256, 349, 770};
        int arr2[] = {72, 86, 113, 119, 265, 445, 892};

        System.out.println(Arrays.toString(obj.sort(arr1, arr2)));

    }


    private int [] sort(int [] arr1, int arr2 []){

        int s1 = 0;
        int s2 = 0;
        int res [] = new int[arr1.length + arr2.length];

        int index = 0;
        while(s1 < arr1.length && s2 < arr2.length){
            int first = arr1[s1];
            int sec = arr2[s2];


            if(first < sec){
                res[index] = first;
                s1++;
            }else{
                res[index] = sec;
                s2++;
            }

            index++;


        }

        while(s1 < arr1.length){
            res[index++] = arr1[s1++];
        }

        while(s2 < arr2.length){
            res[index++] = arr2[s2++];
        }

        return res;

    }
}
