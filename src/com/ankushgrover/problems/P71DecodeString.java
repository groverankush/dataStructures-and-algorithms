package com.ankushgrover.problems;

import java.util.Stack;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 02/09/19
 * <p>
 * https://leetcode.com/problems/decode-string/
 */
public class P71DecodeString {

    public static void main(String[] args) {

        System.out.println(decodeString("2[abc]3[cd]ef"));

    }


    private static String decodeString(String s) {

        Stack<Integer> iStack = new Stack<>();
        Stack<Character> cStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (!Character.isDigit(ch) && ch != ']')
                cStack.push(ch);

            else if (Character.isDigit(ch)) {
                int num = 0;
                int j = i;

                while (Character.isDigit(s.charAt(i))) {
                    char n = s.charAt(j);
                    num = (num * 10) + (n - '0');
                    i++;
                    j++;
                }
                i--;
                iStack.push(num);
            } else {
                StringBuilder builder = new StringBuilder();


                while (cStack.peek() != '[') {
                    builder.append(cStack.pop());
                }
                cStack.pop();

                int mul = iStack.pop();

                for (int j = 0; j < mul; j++) {

                    for (int k = builder.length() - 1; k >= 0; k--) {
                        cStack.push(builder.charAt(k));
                    }

                }
            }

        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < cStack.size(); i++) {
            builder.append(cStack.elementAt(i));
        }

        return builder.toString();
    }
}
