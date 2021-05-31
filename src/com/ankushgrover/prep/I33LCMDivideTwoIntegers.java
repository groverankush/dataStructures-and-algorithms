package com.ankushgrover.prep;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 29/05/21
 */
public class I33LCMDivideTwoIntegers {

    public static void main(String[] args) {

        I33LCMDivideTwoIntegers obj = new I33LCMDivideTwoIntegers();
        int dividend = 10;
        int divisor = 2;
        System.out.println(obj.divide(dividend, divisor));

    }

    public int divide(int dividend, int divisor) {

        if (dividend == 1 << 31 && divisor == -1) return Integer.MAX_VALUE;

        boolean isPositive = (dividend < 0 && divisor < 0) || (dividend >= 0 && divisor >= 0);

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);


        int res = 0;
        while (dividend - divisor >= 0) {

            int count = 0;


            while (dividend - (divisor << 1 << count) >= 0) {
                count++;
            }


            res += 1 << count;
            dividend = dividend - (divisor << 1 << count);

            System.out.println("Dividend: " + dividend + " count: " + count + " Result: " + res);

        }


        return isPositive ? res : -res;

    }
}
