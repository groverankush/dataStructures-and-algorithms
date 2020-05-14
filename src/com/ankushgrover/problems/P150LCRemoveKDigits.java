package com.ankushgrover.problems;

import java.util.Stack;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 13/05/20
 */
public class P150LCRemoveKDigits {

    public static void main(String[] args) {
        P150LCRemoveKDigits obj = new P150LCRemoveKDigits();
        System.out.println(obj.removeKdigits("112", 1));

    }

    public String removeKdigits(String num, int k) {
        int length = num.length();
        if (k == 0)
            return num;
        if (k == length)
            return "0";

        Stack<Character> stack = new Stack<>();

        stack.push(num.charAt(0));

        int i = 1;
        for (i = 1; i < num.length() && k > 0; i++) {

            int diff = stack.isEmpty() ? -1 : num.charAt(i) - stack.peek();

            if (diff >= 0)
                stack.push(num.charAt(i));
            else {
                if (!stack.isEmpty()) {
                    stack.pop();
                    --k;
                }

                if (!(stack.isEmpty() && num.charAt(i) == '0')) {
                    stack.push(num.charAt(i));

                }

            }
        }


        StringBuilder result = new StringBuilder();
        for (Character character : stack) {
            result.append(character);
        }
        for(; i < num.length(); i++){
            if(result.length() == 0 && num.charAt(i) == '0')
                continue;
            result.append(num.charAt(i));
        }

        return result.length()==0 ? "0" : result.toString();
    }
}
