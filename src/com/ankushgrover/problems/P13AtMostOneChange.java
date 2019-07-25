package com.ankushgrover.problems;

public class P13AtMostOneChange {

    public static void main(String[] args) {

        int [] arr = {50,60, 40 ,30,65};
        System.out.println(checkList(arr));
    }

    private static boolean checkList(int[] arr) {
        int start = 0;
        int end = arr.length;
        int status = 0;

        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] < arr[i + 1])
                status++;
        }

        return status <= 1;
    }
}
