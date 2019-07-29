package com.ankushgrover.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/
 */
public class P21GenerateParenthesis {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(0));
    }

    private static List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<>();
        generate(n, n, n, "", list);
        return list;
    }

    private static void generate(int start, int end, int n, String s, List<String> list) {

        if(start < 0 || end < 0)
            return;

        if (start <= end) {
            generate(start - 1, end, n, s + "(", list);
        }
        if (start < end) {
            generate(start, end - 1, n, s + ")", list);
        }

        if (start == end && start == 0) {
            list.add(s);
        }
    }
}
