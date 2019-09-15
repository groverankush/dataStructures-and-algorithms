package com.ankushgrover.problems;

import java.util.Stack;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 15/09/19
 */
public class P112LCReverseSubstringsBetweenPairs {

    public static void main(String[] args) {

        P112LCReverseSubstringsBetweenPairs obj = new P112LCReverseSubstringsBetweenPairs();
        System.out.println(obj.reverseParentheses("(ed(et(oc))el)"));
    }

    public String reverseParentheses(String s) {

        if (s == null || s.length() == 0)
            return "";

        Stack<Character> stack = new Stack<>();

        stack.push(s.charAt(0));

        int j = 1;
        StringBuilder builder = new StringBuilder();

        while (j < s.length()) {

            if (s.charAt(j) == ')') {

                builder = new StringBuilder();
                while (stack.peek() != '(') {
                    builder.append(stack.pop());
                }
                stack.pop();
                int i = 0;
                while (i < builder.length()) {
                    stack.push(builder.charAt(i));
                    i++;
                }


            } else {
                stack.push(s.charAt(j));
            }

            j++;
        }
        StringBuilder result = new StringBuilder();

        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }

        return result.toString();
    }
}
