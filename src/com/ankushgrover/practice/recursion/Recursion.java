package com.ankushgrover.practice.recursion;


public class Recursion {

    public static void main(String[] args) {


        System.out.println(fib(7));

    }


    /**
     * A demo to show work done while stack building.
     * <p>
     * PS: Print numbers n -> 0 when n is passed to a function.
     * Example: if n=5  print 5 4 3 2 1 0
     *
     * @param num
     */
    private static void printDecreasing(int num) {
        if (num < 0)
            return;

        System.out.println(num);

        printDecreasing(num - 1);
    }

    /**
     * A demo to show work done while stack falling.
     * <p>
     * PS: Print numbers 0 -> n when n is passed to a function.
     * Example: if n = 5  print 0 1 2 3 4 5
     *
     * @param n
     */
    private static void printIncreasing(int n) {

        if (n < 0)
            return;

        printIncreasing(n - 1);

        System.out.println(n);

    }

    /**
     * A demo to show work done while stack building and falling.
     * <p>
     * PS: Print numbers n -> 1 then 1 -> n when n is passed to a function.
     * Example: if n=5  print 5 4 3 2 1 1 2 3 4 5
     *
     * @param n
     */
    private static void printDecInc(int n) {

        if (n < 1)
            return;

        System.out.println(n);
        printDecInc(n - 1);
        System.out.println(n);

    }

    /**
     * A demo to show work done while stack building and falling.
     * <p>
     * PS: Print numbers n -> 1 then 1 -> n when n is passed to a function skipping 2 at a time.
     * Example: if n=5  print 5 3 1 2 4
     *
     * @param n
     */
    private static void printDecIncSkip(int n) {

        if (n < 1)
            return;

        System.out.println(n);
        printDecIncSkip(n - 2);
        System.out.println(n + 1);

    }

    /**
     * Method to get factorial of a number using recursion.
     *
     * @param n
     * @return
     */
    private static int factorial(int n) {
        if (n < 1)
            return 1;
        return n * factorial(n - 1);
    }

    /**
     * Power of a number
     *
     * @param x : number
     * @param n : power
     * @return
     */
    private static int power(int x, int n) {
        if (n == 0)
            return 1;
        return x * power(x, n - 1);

    }

    private static int fib(int n){

        if(n < 1)
            return 0;

        if(n == 1)
            return 1;


        return fib(n-1) + fib(n-2);

    }

}
