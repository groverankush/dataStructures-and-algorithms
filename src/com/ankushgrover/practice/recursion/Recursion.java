package com.ankushgrover.practice.recursion;


import java.util.Arrays;

public class Recursion {

    public static void main(String[] args) {

        /*
        System.out.println(lastIndex(arr, 0, 2));*/

        int[] arr = {6, 4, 5, 3, 9, 1};
        bubbleSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
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

    private static int fib(int n) {

        if (n < 1)
            return 0;

        if (n == 1)
            return 1;


        return fib(n - 1) + fib(n - 2);

    }

    private static boolean isSorted(int[] arr, int index) {
        if (index > arr.length - 2)
            return true;

        if (arr[index] > arr[index + 1])
            return false;

        return isSorted(arr, index + 1);

    }

    private static int firstIndex(int[] arr, int index, int data) {

        if (index == arr.length)
            return -1;

        if (arr[index] == data)
            return index;

        return firstIndex(arr, index + 1, data);


    }

    private static int lastIndex(int[] arr, int index, int data) {

        if (index == arr.length)
            return -1;

        int i = lastIndex(arr, index + 1, data);

        if (i == -1) {

            if (arr[index] == data)
                return index;

            return -1;

        }
        return i;

    }

    /**
     * *
     * **
     * ***
     * ****
     * *****
     *
     * @param n
     * @param row
     * @param col
     */
    private static void pattern(int n, int row, int col) {

        if (n < 1)
            return;

        if (col <= row) {
            System.out.print("*");
        }

        if (row == col) {
            System.out.print("\n");
            n = n - 1;
            row = row + 1;
            col = 0;
        } else {
            col++;
        }


        pattern(n, row, col);

    }

    private static void bubbleSort(int[] arr, int start, int end) {

        if (end == 0)
            return;

        if (arr[start] > arr[start + 1]) {
            int temp = arr[start];
            arr[start] = arr[start + 1];
            arr[start+1] = temp;
        }

        if (start == end - 1) {

            start = 0;
            end = end - 1;

        } else
            start = start + 1;

        bubbleSort(arr, start, end);
    }


}
