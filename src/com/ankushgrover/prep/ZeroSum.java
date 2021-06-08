package com.ankushgrover.prep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Ankuzsh Grover(ankush.dev2@gmail.com) on 04/06/21
 */
public class ZeroSum {

    public static void main(String[] args) {


        ZeroSum obj = new ZeroSum();

        Scanner sc = new Scanner(System.in);

        int cases = sc.nextInt();


        for (int i = 0; i < cases; i++) {
            int size = sc.nextInt();

            ArrayList<Integer> list = new ArrayList<>();

            for (int j = 0; j < size; j++) {

                list.add(sc.nextInt());

            }
            obj.zeroSum(list);

        }


    }

    void zeroSum(List<Integer> arr) {
        int n = arr.size();
        int sum = 0;
        HashMap<Integer, Integer> prevSum = new HashMap<>();

        int res = 0;


        int currsum = 0;

        for (int i = 0; i < n; i++) {


            currsum += arr.get(i);

            if (currsum == sum)
                res++;

            if (prevSum.containsKey(currsum - sum))
                res += prevSum.get(currsum - sum);


            Integer count = prevSum.get(currsum);
            if (count == null)
                prevSum.put(currsum, 1);
            else
                prevSum.put(currsum, count + 1);
        }

        System.out.println(res);
    }

    /*int memoisation(int arr[]) {
    }*/
}
