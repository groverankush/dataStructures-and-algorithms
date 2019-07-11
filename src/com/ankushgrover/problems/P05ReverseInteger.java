package com.ankushgrover.problems;

/**
 * https://leetcode.com/problems/reverse-integer/
 */
public class P05ReverseInteger {

    public static void main(String[] args) {

        System.out.println(1534236469);
        System.out.println(reverse(1534236469));
    }

    private static int reverse(int x) {

        long result = 0;

        while(x != 0){
            result = ((x%10) + result) * 10;
            x /= 10;

        }
        result /= 10;

        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
            return 0;

        return (int) result;

    }

}
