package com.ankushgrover.practice.recursion;


import java.util.ArrayList;

public class Recursion {

    public static void main(String[] args) {


        //System.out.println(getSubsequence("abc").toString());

        long prev = System.nanoTime();
        System.out.println(getBoardPath(0, 10).toString());
        System.out.println("Time Taken: " + (System.nanoTime() - prev));
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
            arr[start + 1] = temp;
        }

        if (start == end - 1) {

            start = 0;
            end = end - 1;

        } else
            start = start + 1;

        bubbleSort(arr, start, end);
    }

    /**
     * find all the occurrences of {@code data} in the array {@code arr}.
     *
     * @param arr
     * @param start
     * @param data
     * @param count
     * @return
     */
    private static int[] allIndices(int[] arr, int start, int data, int count) {

        if (start == arr.length) {
            return new int[]{-1};
        }

        if (arr[start] == data) {
            count++;
        }

        int[] r = allIndices(arr, start + 1, data, count);

        if (r.length == 1 && r[0] == -1) {
            r = new int[count];
        }

        if (arr[start] == data) {
            r[count - 1] = start;
        }

        return r;
    }


    //********************************************* Part 2 ********************************************************

    /**
     * for input "abc" out will be -> ["", a, b, ab, c, ac, bc, abc]
     *
     * @param str
     * @return
     */
    private static ArrayList<String> getSubsequence(String str) {

        if (str.equals("")) {
            ArrayList<String> list = new ArrayList<>();
            list.add("");
            return list;
        }

        char cc = str.charAt(0);

        String ros = str.substring(1);
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> recResult = getSubsequence(ros);

        for (String s : recResult) {
            result.add(s);
            result.add(cc + s);
        }
        return result;

    }

    /**
     * If input is "abc" output -> [abc, bac, bca, acb, cab, cba]
     *
     * @param s
     * @return
     */
    private static ArrayList<String> getPermutations(String s) {

        if (s.length() == 1) {
            ArrayList<String> list = new ArrayList<String>();
            list.add(s);
            return list;
        }

        String first = s.substring(0, 1);
        String second = s.substring(1);

        ArrayList<String> permutations = getPermutations(second);
        ArrayList<String> result = new ArrayList<String>();

        for (String perm : permutations) {

            StringBuilder builder = new StringBuilder(perm);
            for (int i = 0; i <= builder.length(); i++) {
                result.add(builder.insert(i, first).toString());
                builder.replace(i, i + 1, "");
            }


        }
        return result;

    }

    /**
     * Determine all the ways to reach from 0 to 10.
     * <p>
     * Example {1111111111,111111112,11111113, 91, 82}
     *
     * @param cur
     * @param end
     * @return
     */
    private static ArrayList<String> getBoardPath(int cur, int end) {

        if (cur == end) {
            ArrayList<String> list = new ArrayList<>();
            list.add("");
            return list;
        }

        if (cur > end) {
            return new ArrayList<>();
        }

        ArrayList<String> result = new ArrayList<String>();
        for (int dice = 1; dice <= 6; dice++) {
            ArrayList<String> rr = getBoardPath(cur + dice, end);

            for (String s : rr) {
                result.add(dice + s);
            }
        }

        return result;
    }


}
