package com.ankushgrover.prep;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 31/07/21
 */
public class I59LCHRemoveInvalidParenthesis {

    public static void main(String[] args) {

        I59LCHRemoveInvalidParenthesis obj = new I59LCHRemoveInvalidParenthesis();
        String s = "n";
        System.out.println(obj.removeInvalidParentheses(s));
    }

    public List<String> removeInvalidParentheses(String s) {
        HashSet<String> set = new HashSet<>();
        fun(s, 0, new StringBuilder(), 0, set);

        int length = Integer.MIN_VALUE;
        for (String str : set) {
            if (str.length() > length) {
                length = str.length();
            }
        }

        List<String> res = new ArrayList<>();
        for (String str : set) {

            if (str.length() == length) {
                res.add(str);
            }
        }

        if (res.isEmpty())
            res.add("");

        return res;
    }


    private void fun(String s, int index, StringBuilder builder, int checkSum, HashSet<String> res) {

        if (index > s.length() || checkSum < 0)
            return;

        if (index == s.length()) {
            if (checkSum == 0 && isValid(builder)) {
                res.add(builder.toString());
            }
            return;
        }

        char ch = s.charAt(index);

        builder.append(ch);
        checkSum += charCheckSum(ch);


        fun(s, index + 1, builder, checkSum, res);


        char removedCh = builder.charAt(builder.length() - 1);
        builder.replace(builder.length() - 1, builder.length(), "");
        checkSum -= charCheckSum(removedCh);

        fun(s, index + 1, builder, checkSum, res);


    }

    private int charCheckSum(char ch) {
        if (ch == '(')
            return 1;
        if (ch == ')')
            return -1;
        return 0;
    }

    private boolean isNotLower(char ch) {
        return ch < 'a' || ch > 'z';
    }

    private boolean isValid(StringBuilder builder) {
        //return builder.length() > 0 && isNotLower(builder.charAt(0)) && isNotLower(builder.charAt(builder.length() - 1));
        return true;
    }
}
