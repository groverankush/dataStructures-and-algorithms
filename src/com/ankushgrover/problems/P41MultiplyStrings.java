package com.ankushgrover.problems;

public class P41MultiplyStrings {

    public static void main(String[] args) {

        String f = "";
        String s = "956349";
        System.out.println(String.format("%s X %s", f, s));
        System.out.println(multiply(f, s));
        System.out.println("Actual: " + (Integer.valueOf(f) * Integer.valueOf(s)));
    }

    private static String multiply(String num1, String num2) {

        if (num1 == null || num1.isEmpty() || num1.equals("0") || num2 == null || num2.isEmpty() || num2.equals("0"))
            return "0";

        char first[] = num1.toCharArray();
        char second[] = num2.toCharArray();

        StringBuilder ans = new StringBuilder();

        int count = 0;
        for (int i = second.length - 1; i >= 0; i--) {

            int carry = 0;
            StringBuilder builder = new StringBuilder();
            insertZeros(builder, count);

            for (int j = first.length - 1; j >= 0; j--) {


                int si = second[i] - '0';
                int fi = first[j] - '0';

                int prod = (si * fi) + carry;
                int remainder = prod % 10;
                carry = prod / 10;
                builder.insert(0, remainder);
            }
            if (carry > 0) {
                builder.insert(0, carry);
            }
            ans = add(ans, builder);
            count++;
        }


        return ans.toString();
    }

    private static void insertZeros(StringBuilder builder, int count) {
        for (int i = 0; i < count; i++) {
            builder.insert(0, 0);
        }
    }

    private static StringBuilder add(StringBuilder b1, StringBuilder b2) {
        StringBuilder b3 = new StringBuilder();
        int s1 = b1.length();
        int s2 = b2.length();
        int carry = 0;
        while (s1 > 0 || s2 > 0) {
            int c1 = 0;
            int c2 = 0;
            if (s1 > 0)
                c1 = b1.charAt(s1 - 1) - '0';
            if (s2 > 0)
                c2 = b2.charAt(s2 - 1) - '0';
            int sum = c1 + c2 + carry;
            b3.insert(0, (sum % 10));
            carry = sum / 10;
            s1--;
            s2--;
        }
        if (carry > 0)
            b3.insert(0, carry);

        return b3;
    }
}
