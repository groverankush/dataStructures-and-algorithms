package com.ankushgrover.problems;

/**
 * https://leetcode.com/problems/strobogrammatic-number/
 */
public class P48StrobogrammaticNumber {

    public static void main(String[] args) {
        String num = "0";

        System.out.println(isStrobogrammatic(num));
    }

    private static boolean isStrobogrammatic(String num) {


        int start = 0, end = num.length() - 1;

        while (start <= end) {
            char ch = num.charAt(end);

            switch (ch) {
                case '9':
                    ch = '6';
                    break;

                case '6':
                    ch = '9';
                    break;

                case '0':
                case '1':
                case '8':
                    break;

                default:
                    ch = '-';
                    break;
            }

            if (ch != num.charAt(start))
                return false;

            start++;
            end--;
        }

        return true;

    }
}
