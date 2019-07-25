package com.ankushgrover.problems;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 */
public class P14LongestCommonPrefix {

    public static void main(String[] args) {
        String[] arr = new String[]{"lflower", "oflo", "llwe"};
        System.out.println(longestCommonPrefix(arr));
    }

    private static String longestCommonPrefix(String[] strs) {

        if (strs.length == 0)
            return "";

        StringBuilder builder = new StringBuilder();

        int index = 0;
        boolean exit = false;
        while (index < strs[0].length()) {
            char ch = strs[0].charAt(index);
            for (int i = 1; i < strs.length; i++) {

                if (index >= strs[i].length()) {
                    exit = true;
                    break;
                }

                if (ch != strs[i].charAt(index)) {
                    exit = true;
                    break;
                } else exit = false;
            }
            if (!exit) {
                builder.append(ch);
                index++;
            } else break;
        }

        return builder.toString();
    }
}
