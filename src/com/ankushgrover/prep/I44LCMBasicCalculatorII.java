package com.ankushgrover.prep;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 27/06/21
 */
public class I44LCMBasicCalculatorII {


    private static final int ADD = -1;
    private static final int SUB = -2;
    private static final int MUL = -3;
    private static final int DIV = -4;

    public static void main(String[] args) {
        I44LCMBasicCalculatorII obj = new I44LCMBasicCalculatorII();
        String s = "2*3+4";
        System.out.println(obj.calculate(s));
    }


    public int calculate(String s) {

        HashMap<Character, Integer> map = createSignMap();


        Stack<Integer> stack = parse(s, map);
        stack = divideAndMultiply(stack);
        return addAndSubtract(stack);

    }

    private int addAndSubtract(Stack<Integer> stack) {
        int res = stack.get(0);
        int i = 1;
        while (i < stack.size()) {
            int e = stack.get(i);
            if (e < 0) {
                int op1 = res;
                int op2 = stack.get(i + 1);

                if (e == ADD) {
                    res = op1 + op2;
                } else {
                    res = op1 - op2;
                }

                i += 2;
            }
        }
        return res;
    }

    private Stack<Integer> divideAndMultiply(Stack<Integer> stack) {
        Stack<Integer> res = new Stack<>();

        int i = 0;
        while (i < stack.size()) {
            int e = stack.get(i);

            if (e < -2) {
                int op1 = res.pop();
                int op2 = stack.get(i + 1);

                if (e == DIV) {
                    res.push(op1 / op2);
                } else {
                    res.push(op1 * op2);
                }

                i += 2;
            } else {

                res.push(e);
                i++;

            }
        }

        return res;


    }

    private HashMap<Character, Integer> createSignMap() {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('+', ADD);
        map.put('-', SUB);
        map.put('*', MUL);
        map.put('/', DIV);

        return map;
    }


    private Stack<Integer> parse(String s, HashMap<Character, Integer> map) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == ' ')
                continue;

            if (ch >= '0' && ch <= '9') {

                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(ch - '0');
                } else {
                    int last = stack.pop() * 10 + ch - '0';
                    stack.push(last);
                }
            } else {
                stack.push(map.get(ch));
            }

        }

        return stack;
    }


}
