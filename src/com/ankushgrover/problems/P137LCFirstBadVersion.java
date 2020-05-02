package com.ankushgrover.problems;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 01/05/20
 * <p>
 * https://leetcode.com/problems/first-bad-version
 */
public class P137LCFirstBadVersion {

    private int badVersion;

    private P137LCFirstBadVersion(int max, int num) {
        badVersion = num;
        System.out.println(firstBadVersion(max));
    }

    public static void main(String[] args) {
        new P137LCFirstBadVersion(2126753390, 1702766719);
        //new P137LCFirstBadVersion(6,6);
    }

    private boolean isBadVersion(int n) {
        return n >= badVersion;
    }

    private int firstBadVersion(int n) {


        int low = 1;
        int high = n;
        int pos = -1;

        while (low <= high) {
            if (low == high)
                return isBadVersion(low) ? low : pos;

            int mid = low + (high - low + 1) / 2;
            //System.out.println(low + " " + high+" "+mid);


            if (isBadVersion(mid)) {
                high = mid - 1;
                pos = mid;
            } else {
                low = mid + 1;
                //return search(mid + 1, high, pos);
            }
        }

        return pos;
        //return search(1, n, -1);

    }


    /*private int search(int low, int high, int pos) {

        while (low <= high) {
            if (low == high)
                return isBadVersion(low) ? low : pos;

            int mid = (high + low) / 2;

            if (isBadVersion(mid)) return search(low, mid - 1, mid);
            else return search(mid + 1, high, pos);
        }

    }*/
}
