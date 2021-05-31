package com.ankushgrover.prep.random;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 26/05/21
 */
public class I33LCMDivideTwoIntegers {

    public static void main(String[] args) {

        I33LCMDivideTwoIntegers obj = new I33LCMDivideTwoIntegers();
        int dividend = -2147483648;
        int divisor = -1;
        System.out.println(obj.divide(dividend, divisor));
    }

    public int divide(int dividend, int divisor) {
        boolean isPositive = (dividend < 0 && divisor < 0) || (dividend >= 0 && divisor >= 0);

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int count = 0;

        while (dividend >= divisor && count >= 0) {
            count++;
            dividend -= divisor;
        }

        if (count < 0)
            return Integer.MAX_VALUE;

        return isPositive ? count : count * -1;

    }
}
