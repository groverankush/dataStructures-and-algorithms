package com.ankushgrover.problems;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 04/07/20
 */
public class P182LCMUglyNumbersII {

    public static void main(String[] args) {

        P182LCMUglyNumbersII obj = new P182LCMUglyNumbersII();
        System.out.println(obj.nthUglyNumber(12));

    }


    public int nthUglyNumber(int n) {
        int c2 = 2, c3 = 3, c5 = 5;
        TreeSet<Integer> set = new TreeSet<>();

        set.add(1);

        while (set.size() < n) {
            int num = 0;
            if (c2 < c3) {
                if (c2 < c5) {
                    num = c2;
                    c2 += 2;
                } else {
                    num = c5;
                    c5 += 5;
                }
            } else {
                if (c3 < c5) {
                    num = c3;
                    c3 += 3;
                } else {
                    num = c5;
                    c5 += 5;
                }
            }
            set.add(num);
        }

        int i = 1;
        Iterator<Integer> iter = set.iterator();

        while (i < n) {
            iter.next();
            i++;
        }
        return iter.next();

    }
}
