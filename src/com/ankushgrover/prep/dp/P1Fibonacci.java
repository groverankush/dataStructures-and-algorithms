package com.ankushgrover.prep.dp;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 15/05/21
 */
public class P1Fibonacci {
    //0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418

    public static void main(String[] args) {


        P1Fibonacci obj = new P1Fibonacci();


        int fib = 50;
        long[] map = new long[fib + 1];

        System.out.println(fib + " :: " + obj.dpFib(fib, map));
        System.out.println(fib + " :: " + obj.normalFib(fib));


    }


    private long normalFib(int n) {

        if (n <= 2)
            return 1;

        return normalFib(n - 1) + normalFib(n - 2);

    }

    private long dpFib(int n, long[] dp) {

        if (dp[n] != 0)
            return dp[n];

        if (n <= 2)
            return 1;

        dp[n] = dpFib(n - 1, dp) + dpFib(n - 2, dp);
        return dp[n];

    }
}
