package com.ankushgrover.interview;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 15/07/20
 * https://leetcode.com/problems/reverse-words-in-a-string/
 * <p>
 * #medium
 */
public class P191LCMReverseWordsInAString {

    public static void main(String[] args) {
    }

    public String reverseWords(String s) {


        StringBuilder result = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (temp.length() > 0) {
                    result.append(temp);
                    result.append(" ");
                    temp = new StringBuilder();
                }
            } else {
                temp.insert(0, s.charAt(i));
                //temp.append(s.charAt(i));
            }
        }

        if (temp.length() > 0) {
            result.append(temp);
        } else if (result.length() > 0) {
            result.deleteCharAt(result.length() - 1);
        }

        return result.toString();
    }
}
