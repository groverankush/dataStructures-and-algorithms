package com.ankushgrover.prep;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 31/05/21
 */
public class I35LCMSumOfTwoIntegers {

    public static void main(String[] args) {
        int a = -12;
        int b = -8;

        I35LCMSumOfTwoIntegers obj = new I35LCMSumOfTwoIntegers();


        System.out.println(a + b);
        System.out.println(obj.getSum(a, b));
        System.out.println(obj.getSumOptimised(a, b));
    }

    public int getSumOptimised(int a, int b) {

        while (b != 0) {

            int xor = a ^ b;
            int and = a & b;

            and = and << 1;

            a = xor;
            b = and;

        }

        return a;

    }


    public int getSum(int a, int b) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);

        if (min == 0)
            return max;

        int q = max / min;
        int rem = max % min;

        int res = min * ++q;
        while (rem != 0) {
            if (rem > 0) {
                rem--;
                res++;
            } else {
                rem++;
                res--;
            }
        }


        return res;

    }

}
