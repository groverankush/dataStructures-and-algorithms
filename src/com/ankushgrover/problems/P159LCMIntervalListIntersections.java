package com.ankushgrover.problems;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 23/05/20
 */
public class P159LCMIntervalListIntersections {

    public static void main(String[] args) {

        P159LCMIntervalListIntersections obj = new P159LCMIntervalListIntersections();
        int[][] first = {{4, 6}, {7, 8}, {10, 17}};
        int[][] second = {{5, 10}};

        int[][] result = obj.intervalIntersection(first, second);

        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }


    }

    public int[][] intervalIntersection1(int[][] A, int[][] B) {

        int x = 0, y = 0;
        ArrayList<int[]> list = new ArrayList<>();

        while (x < A.length && y < B.length) {

            int maxStart = Math.max(A[x][0], B[y][0]);
            int minEnd = Math.min(A[x][1], B[y][1]);

            if(maxStart <= minEnd){
                list.add(new int[] {maxStart, minEnd} );
            }

            if(A[x][1]<B[y][1])
                x++;
            else y++;




        }

        int[][] result = new int[list.size()][2];

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;


    }

    public int[][] intervalIntersection(int[][] A, int[][] B) {

        int x = 0, y = 0;
        ArrayList<int[]> list = new ArrayList<>();

        while (x < A.length && y < B.length) {

            int[] first = A[x];
            int[] second = B[y];

            if (first[0] == second[0] && first[1] == second[1]) {
                list.add(first);
                x++;
                y++;
            } else if (first[0] == second[0]) {
                int arr[] = {first[0], -1};
                if (first[1] > second[1]) {
                    arr[1] = second[1];
                    y++;
                } else if (first[1] < second[1]) {
                    arr[1] = first[1];
                    x++;
                }
                list.add(arr);
            } else if (first[1] == second[1]) {
                int arr[] = {-1, first[1]};
                if (first[0] < second[0])
                    arr[0] = second[0];
                else arr[0] = first[0];

                x++;
                y++;
                list.add(arr);
            } else if (first[0] == second[1]) {
                int[] arr = {first[0], first[0]};
                list.add(arr);
                y++;
            } else if (first[1] == second[0]) {
                int[] arr = {first[1], first[1]};
                list.add(arr);
                x++;
            } else if (first[0] < second[0] && first[1] > second[0] && first[1] < second[1]) {
                int arr[] = {second[0], first[1]};
                list.add(arr);
                x++;
            } else if (first[0] > second[0] && first[0] < second[1] && first[1] > second[1]) {
                int arr[] = {first[0], second[1]};
                list.add(arr);
                y++;
            } else if (first[0] < second[0] && first[1] > second[1]) {
                int arr[] = {second[0], second[1]};
                y++;
                list.add(arr);
            } else if (second[0] < first[0] && second[1] > first[1]) {
                int arr[] = {first[0], first[1]};
                x++;
                list.add(arr);
            } else if (first[1] < second[0]) {
                x++;
            } else if (first[0] > second[1]) {
                y++;
            }
        }

        int[][] result = new int[list.size()][2];

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;


    }


}
