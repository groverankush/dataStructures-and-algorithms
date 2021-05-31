package com.ankushgrover.prep;

import java.util.HashMap;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 30/05/21
 */
public class I34LCMFractionToRecurringDecimal {

    public static void main(String[] args) {


        int num = 22;
        int den = 7;

        Double f = num / (den * 1.0);

        System.out.println(f.toString());

        I34LCMFractionToRecurringDecimal obj = new I34LCMFractionToRecurringDecimal();

        System.out.println(obj.fractionToDecimal(num, den));
    }


    public String fractionToDecimal(int n, int d) {

        if (n == 0)
            return "0";

        boolean isPositive = (n >= 0 && d >= 0) || (n < 0 && d < 0);
        long num = n;
        long den = d;
        num = Math.abs(num);
        den = Math.abs(den);

        boolean isDecimalAdded = false;

        StringBuilder res = new StringBuilder();
        HashMap<Long, Integer> map = new HashMap<>();
        boolean isNormal = false;

        int index = 0;

        while (true) {

            long q = num / den;
            long rem = num % den;


            if (q > 0) {

                isNormal = true;
                if (isDecimalAdded) {
                    Integer i = map.get(num);

                    if (i == null) {
                        index = append(res, q);
                        map.put(num, index);
                    } else {
                        res.insert(i, "(");
                        res.append(")");
                        break;
                    }
                } else {
                    index = append(res, q);

                }

                num = rem;


            } else {

                if (!isDecimalAdded) {
                    if (res.length() == 0) {
                        index = append(res, 0);
                    }

                    res.append(".");
                    index++;

                    isDecimalAdded = true;
                    num = num * 10;

                } else {
                    if (!isNormal) {
                        index = append(res, 0);
                    }
                    num = num * 10;


                }


                isNormal = false;
                continue;

            }

            if (rem == 0)
                break;

        }
        if (!isPositive)
            res.insert(0, "-");
        return res.toString();

    }

    private int append(StringBuilder builder, long s) {
        int length = builder.length();
        builder.append(s);
        return length;
    }
}

