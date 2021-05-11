package com.ankushgrover.practice;


import java.util.ArrayList;
import java.util.List;

public class Recursion {

    public static void main(String[] args) {


        long prev = System.nanoTime();
        int size = 3;
        //printMazePathDiagonal(size, size, 0, 0, "");
        //System.out.println(countMazePathDiagonal(size, size, 0, 0));
        //System.out.println("Time Taken: " + (System.nanoTime() - prev));


        List<String> perms = getPermutations("123");

        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        List<List<Integer>> list = getPermutations(l);
        System.out.println(list);


        //System.out.println(getSubsequence("abcdefg")) ;
        //System.out.println(getSubsequenceMod(1, 10, 1000));
        //System.out.print(perms);
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

    private static ArrayList<Integer> getSubsequenceMod(int start, int sum, int max) {

        if (start == max) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(max);
            return list;
        }

        int cc = start;

        int ros = cc + 1;
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> recResult = getSubsequenceMod(ros, sum, max);

        for (Integer s : recResult) {
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
     * input is [1,2,3,4] -> [[1,2,3,4], [1,2,4,3]...]
     *
     * @param s
     * @return
     */
    private static List<List<Integer>> getPermutations(List<Integer> s) {

        if (s.size() == 1) {
            ArrayList<List<Integer>> list = new ArrayList<>();
            List<Integer> l = new ArrayList<>(s);
            list.add(l);
            return list;
        }

        int first = s.get(0);
        s.remove(0);

        List<List<Integer>> perms = getPermutations(s);
        List<List<Integer>> result = new ArrayList<>();

        for (List<Integer> perm : perms) {
            List<Integer> temp = new ArrayList<>(perm);

            for (int i = 0; i <= perm.size(); i++) {
                temp.add(i, first);
                result.add(new ArrayList<Integer>(temp));
                temp.remove(i);
            }
        }

        return result;

    }

    /**
     * Determine all the ways to reach from 0 to 10 on a roll of die.
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

    /**
     * Get all the possible paths from {0,0} to {row, col} by using one horizontal / vertical move at a time.
     *
     * @param ch
     * @param cv
     * @param row
     * @param col
     * @return
     */
    private static ArrayList<String> getMazePath(int ch, int cv, int row, int col) {

        if (ch == row - 1 && cv == col - 1) {
            ArrayList<String> bl = new ArrayList<>();
            bl.add("");
            return bl;
        }

        if (ch == row || cv == col) {
            return new ArrayList<String>();
        }

        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            ArrayList<String> list = getMazePath(i == 0 ? ch + 1 : ch, i == 1 ? cv + 1 : cv, row, col);

            for (String path : list) {
                result.add(path + (i == 0 ? "V" : "H"));
            }

        }

        return result;

    }

    private static ArrayList<String> getMazePathDiagonal(int ch, int cv, int row, int col) {

        if (ch == row - 1 && cv == col - 1) {
            ArrayList<String> bl = new ArrayList<>();
            bl.add("");
            return bl;
        }

        if (ch == row || cv == col) {
            return new ArrayList<String>();
        }

        ArrayList<String> result = new ArrayList<>();

        ArrayList<String> hl = getMazePathDiagonal(ch, cv + 1, row, col);
        for (String path : hl) {
            result.add(path + "H");
        }

        hl = getMazePathDiagonal(ch + 1, cv, row, col);
        for (String path : hl) {
            result.add(path + "V");
        }

        hl = getMazePathDiagonal(ch + 1, cv + 1, row, col);
        for (String path : hl) {
            result.add(path + "D");
        }

        return result;

    }

    /**
     * Fit 1*2 Dominos In 2*N Strip
     *
     * @param o
     * @param n
     * @return : List of strings of pattern
     */
    private static ArrayList<String> noOfWays(int o, int n) {
        if (o == n) {
            ArrayList<String> list = new ArrayList<>();
            list.add("");
            return list;
        }

        if (o > n) {
            return new ArrayList<>();
        }

        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> vl = noOfWays(o + 1, n);
        for (String c : vl) {
            result.add("v" + c);
        }

        ArrayList<String> hl = noOfWays(o + 2, n);
        for (String c : hl) {
            result.add("h" + c);
        }

        return result;

    }

    /**
     * Fit 1*2 Dominos In 2*N Strip
     *
     * @param n
     * @return : no of pattern
     */
    private static int noOfWays(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;

        return noOfWays(n - 1) + noOfWays(n - 2);

    }

    //************************************ Part 3 ****************************************************************

    private static void printSubSequences(String str, String result) {
        if (str.length() == 0) {
            System.out.println(result);
            return;
        }
        char ch = str.charAt(0);
        String ros = str.substring(1);
        printSubSequences(ros, result);
        printSubSequences(ros, result + ch);
    }

    /**
     * Print permutations of passed string.
     * "abc" -> abc, acb, bac, bca, cab, cba
     *
     * @param str:    required string
     * @param result: Empty String
     */
    private static void printPermutations(String str, String result) {
        if (str.length() == 0) {
            System.out.println(result);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String roq = str.substring(0, i) + str.substring(i + 1);

            printPermutations(roq, result + ch);
        }
    }

    private static void printBoardPath(int current, int end, String result) {

        if (current == end) {
            System.out.println(result);
            return;
        }

        if (current > 10)
            return;

        for (int i = 1; i <= 6; i++) {
            printBoardPath(current + i, end, result + i);
        }
    }

    private static int countBoardPath(int current, int end) {
        if (current == end) {
            return 1;
        }
        if (current > 10)
            return 0;

        int paths = 0;
        for (int i = 1; i <= 6; i++) {
            paths += countBoardPath(current + i, end);
        }
        return paths;
    }

    private static void printMazePath(int rows, int cols, int cr, int cc, String result) {
        if (cc == cols - 1 && cr == rows - 1) {
            System.out.println(result);
            return;
        }

        if (cc == cols || cr == rows)
            return;

        printMazePath(rows, cols, cr + 1, cc, result + "V");
        printMazePath(rows, cols, cr, cc + 1, result + "H");
    }

    private static int countMazePath(int rows, int cols, int cr, int cc) {
        if (cr == rows - 1 && cc == cols - 1)
            return 1;

        if (cr == rows || cc == cols)
            return 0;

        int paths = 0;
        paths += countMazePath(rows, cols, cr, cc + 1);
        paths += countMazePath(rows, cols, cr + 1, cc);

        return paths;
    }

    private static void printMazePathDiagonal(int rows, int cols, int cr, int cc, String path) {
        if (cc == cols - 1 && cr == rows - 1) {
            System.out.println(path);
            return;
        }

        if (cc == cols || cr == rows)
            return;

        printMazePathDiagonal(rows, cols, cr, cc + 1, path + "H"); // Horizontal
        printMazePathDiagonal(rows, cols, cr + 1, cc, path + "V"); // Vertical
        printMazePathDiagonal(rows, cols, cr + 1, cc + 1, path + "D"); // Diagonal
    }

    private static int countMazePathDiagonal(int rows, int cols, int cr, int cc) {
        if (cc == cols - 1 && cr == rows - 1) {
            return 1;
        }

        if (cc == cols || cr == rows)
            return 0;

        int paths = 0;

        paths += countMazePathDiagonal(rows, cols, cr, cc + 1); // Horizontal
        paths += countMazePathDiagonal(rows, cols, cr + 1, cc); // Vertical
        paths += countMazePathDiagonal(rows, cols, cr + 1, cc + 1); // Diagonal

        return paths;
    }

}
