package com.ankushgrover.prep;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 14/04/21
 */
public class I1HRENumberLineJumps {

    public static void main(String[] args) {
    }

    static String kangaroo(int x1, int v1, int x2, int v2) {

        double res = (x2 - x1) / ((v1 - v2) * 1.0);

        if (isInt(res) && res > 0.f) {
            return "YES";
        }

        return "NO";
    }

    static boolean isInt(double d) {
        return d == (int) d;
    }
}
