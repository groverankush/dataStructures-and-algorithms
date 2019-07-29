package com.ankushgrover.problems;

/**
 * You are given a positive integer N which represents the number of steps in a staircase. You can either
 * climb 1 or 2 steps at a time. Write a function that returns the number of unique ways to climb the stairs.
 * <p>
 * def staircase(n):
 * # Fill this in.
 * <p>
 * print staircase(4)
 * # 5
 * print staircase(5)
 * # 8
 */
public class P20Staircase {

    public static void main(String[] args) {
        int stairs = 30;
        long time = System.nanoTime();
        System.out.println(staircaseIterative(stairs));
        System.out.println("time taken: " + (System.nanoTime() - time));

        time = System.nanoTime();
        System.out.println(staircase(0, stairs));
        System.out.println("time taken: " + (System.nanoTime() - time));
    }

    private static int staircaseIterative(int stairs) {
        if (stairs == 0)
            return 0;

        if (stairs == 1)
            return 1;

        int p0 = 1, p1 = 1;
        int result = 0;
        for (int i = 2; i <= stairs; i++) {
            result = p0 + p1;
            p0 = p1;
            p1 = result;
        }

        return result;
    }

    private static int staircase(int current, int end) {

        if (current == end)
            return 1;

        if (current > end)
            return 0;

        int paths = 0;

        paths += staircase(current + 1, end);
        paths += staircase(current + 2, end);

        return paths;


    }
}
