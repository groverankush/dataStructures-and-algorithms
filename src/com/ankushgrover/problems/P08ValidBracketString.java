package com.ankushgrover.problems;

import java.util.Stack;

/**
 * Imagine you are building a compiler. Before running any code, the compiler must check that the parentheses in the program are balanced. Every opening bracket must have a corresponding closing bracket. We can approximate this using strings.
 * <p>
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * - Open brackets are closed by the same type of brackets.
 * - Open brackets are closed in the correct order.
 * - Note that an empty string is also considered valid.
 * <p>
 * Example:
 * Input: "((()))"
 * Output: True
 * <p>
 * Input: "[()]{}"
 * Output: True
 * <p>
 * Input: "({[)]"
 * Output: False
 */
public class P08ValidBracketString {


    public static void main(String[] args) {
        System.out.println(isValid(""));
    }

    private static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '}' || ch == ')' || ch == ']') {

                if (stack.isEmpty())
                    return false;

                char pop = stack.pop();
                switch (ch) {
                    case ')':
                        if (pop != '(')
                            return false;
                        break;
                    case ']':
                        if (pop != '[')
                            return false;
                        break;
                    case '}':
                        if (pop != '{')
                            return false;
                        break;
                }

            } else {
                stack.push(ch);
            }

        }

        return stack.size() == 0;
    }
}
