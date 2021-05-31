package com.ankushgrover.prep;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 26/05/21
 */
public class I32Pow {

    public static void main(String[] args) {
        I32Pow obj = new I32Pow();
        double x = 2.00000;
        int n = -2147483648;
        System.out.println(obj.myPow(x, n));
    }

    public double myPow(double x, long n) {

        if (x == 1)
            return x;
        if (n == 0)
            return 1f;

        double power = getPower(x, n < 0 ? -n : n);

        return (n < 0 ? 1 / power : power);
    }

    private double getPower(double x, long n) {
        double res = 1;
        for (int i = 0; i < n; i++) {
            res = res * x;
        }

        return res;
    }
}
