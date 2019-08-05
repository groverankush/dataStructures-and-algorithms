package com.ankushgrover.problems;

import java.util.Stack;

/**
 * https://leetcode.com/problems/longest-valid-parentheses/
 */
public class P32LongestValidParentheses {

    public static void main(String[] args) {
        System.out.println(longestValidParentheses(")()())"));
    }

    private static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty()) {
                    arr[i] = 1;
                    arr[stack.pop()] = 1;
                }
            }
        }
        int temp = 0;
        int max = 0;
        for (int i : arr) {
            if (i == 1) {
                temp++;
            } else {
                max = Math.max(temp, max);
                temp = 0;
            }
        }

        return Math.max(temp, max);
    }
}
