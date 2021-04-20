package com.ankushgrover.prep;

import java.util.Stack;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 16/04/21
 * <p>
 * https://leetcode.com/problems/remove-k-digits/
 */
public class I6LCMRemoveKDigits {

    public static void main(String[] args) {

    }

    public String removeKdigits2(String num, int k) {

        if (num.length() == 1 || num.length() == k) {
            return "0";
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < num.length(); i++) {

            char current = num.charAt(i);


            while (!stack.isEmpty() && stack.peek() > current && k > 0) {
                stack.pop();
                k--;
            }

            if (!stack.isEmpty() || current != '0')
                stack.push(current);


        }

        StringBuilder builder = new StringBuilder();


        for (int i = 0; i < stack.size() - k; i++) {

            builder.append(stack.elementAt(i));

        }

        if (builder.length() == 0)
            builder.append('0');


        return builder.toString();


    }


    public String removeKdigits(String num, int k) {

        if (num.length() == 1 || num.length() == k) {
            return "0";
        }

        StringBuilder builder = new StringBuilder();
        builder.append(num.charAt(0));
        int i;
        for (i = 1; i < num.length() && k > 0; i++) {

            char current = num.charAt(i);
            int lastIndex = builder.length() - 1;
            char last = builder.charAt(lastIndex);

            if (current == last) {
                builder.append(last);
            } else if (current > last) {
                k--;
            } else if (current < last) {
                builder.deleteCharAt(lastIndex);
                builder.append(current);
                k--;
            }

        }


        for (; i < num.length(); i++) {
            builder.append(num.charAt(i));
        }

        while (k > 0 && builder.length() > 0) {
            builder.deleteCharAt(0);
            k--;
        }

        while (builder.length() > 0 && builder.charAt(0) == '0') {
            builder.deleteCharAt(0);
        }

        if (builder.length() == 0)
            builder.append('0');

        return builder.toString();


    }
}
