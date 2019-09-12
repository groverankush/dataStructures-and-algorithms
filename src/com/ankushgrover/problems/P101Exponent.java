package com.ankushgrover.problems;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 12/09/19
 * <p>
 * - Question by Nitin Narwal
 */
public class P101Exponent {

    public static void main(String[] args) {

        System.out.println(exp(3, 10));
    }

    private static double exp(int x, int pow) {
        if (pow == 1)
            return x;

        double exp = exp(x, pow / 2);
        return exp * exp * (pow % 2 == 1 ? x : 1);
    }
}
