package com.ankushgrover.prep.random;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 26/05/21
 */
public class I33LCMDivideTwoIntegers {

    public static void main(String[] args) {

        I33LCMDivideTwoIntegers obj = new I33LCMDivideTwoIntegers();
        int dividend = 10;
        int divisor = 3;
        //System.out.println(obj.divideBitWise(dividend, divisor));
        obj.intuition(divisor, dividend);
    }

    /*
    1. Amazon smart ac
    2. mkbhd ios video
    * */

    private void intuition(int dividend, int divisor){
        int count = 10;

        int target = 3;

        for(int i = 0 ; i < count; i++){



            System.out.println(target);

            target = target << 1 << i;
            //target = target << 1;

        }

    }

    public int divideBitWise(int dividend, int divisor) {

        boolean isPositive = (dividend < 0 && divisor < 0) || (dividend >= 0 && divisor >= 0);

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int res = 0;

        //while(dividend - divisor >= 0)
        while(dividend >= divisor){

            int count = 0;


            while(dividend - (divisor << 1 << count) >= 0){

                int value = divisor << 1 << count;

                System.out.println("******************");
                System.out.println("inside count: " +  count);
                System.out.println("divisor: " + divisor);
                System.out.println("divisor << 1 << count: " + value);
                System.out.println("******************");

                count++;
            }

            int exp = 1 << count;



            System.out.println("******************");
            System.out.println("outside count: " +  count);

            System.out.println("lastRes: " + res + " exp: " + exp);

            System.out.println("lastDividend: " + dividend + " lastDivisor: " + divisor + " divisor << count : " + (divisor << count));

            res += 1 << count;
            dividend = dividend - (divisor << count);

            System.out.println("currentRes: " + res);
            System.out.println("currentDividend: " + dividend + " currentDivisor: " + divisor);
            System.out.println("******************");


        }

        return isPositive ? res : -res;

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
