package com.ankushgrover.prep;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 01/06/21
 * <p>
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 */
public class I36LCMEvaluateReversePolishNotation {

    public static void main(String[] args) {

        I36LCMEvaluateReversePolishNotation obj = new I36LCMEvaluateReversePolishNotation();

        String[] arr = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(obj.evalRPN(arr));
        System.out.println(obj.evalRPNOptimised(arr));


    }

    public int evalRPNOptimised(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {

            if (isOperator(token)) {

                int sec = stack.pop();
                int first = stack.pop();

                int res = operation(first, sec, token);

                stack.push(res);

            } else
                stack.push(Integer.parseInt(token));
        }

        return stack.pop();

    }

    public int evalRPN(String[] tokens) {

        LinkedList<String> list = new LinkedList<>(Arrays.asList(tokens));

        int i = 0;
        while (list.size() != 1) {

            if (isOperator(list.get(i))) {
                int first = Integer.parseInt(list.get(i - 2));
                int sec = Integer.parseInt(list.get(i - 1));
                int res = operation(first, sec, list.get(i));

                //    0   1   2   3   4     5   6   7   8    9   10  11  12
                // ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
                list.set(i - 2, String.valueOf(res));
                list.remove(i--);
                list.remove(i--);

            }
            i++;

        }

        return Integer.parseInt(list.get(0));
    }

    private int operation(int first, int sec, String operator) {
        int res = 0;
        switch (operator) {
            case "+":
                res = first + sec;
                break;
            case "-":
                res = first - sec;
                break;
            case "*":
                res = first * sec;
                break;
            case "/":
                res = first / sec;
                break;
        }
        return res;
    }

    private boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }


}
