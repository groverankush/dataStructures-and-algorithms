package com.ankushgrover.problems;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 20/08/20
 * <p>
 * https://leetcode.com/problems/goat-latin/
 */
public class P211LCEGoatLatin {

    public static void main(String[] args) {
    }

    public String toGoatLatin(String S) {

        if (S.length() == 0)
            return "";

        StringBuilder res = new StringBuilder();

        String[] words = S.split(" ");

        for (int i = 0; i < words.length; i++) {
            String toAppend;
            String chToAppend = "";
            if (isVowel(words[i].charAt(0))) {
                toAppend = words[i];
            } else {
                chToAppend = "" + words[i].charAt(0);
                toAppend = words[i].substring(1, words[i].length());
            }
            res.append(toAppend);
            res.append(chToAppend);
            res.append("ma");
            for (int j = 0; j <= i; j++) {
                res.append('a');
            }

            res.append(' ');


        }
        res.replace(res.length() - 1, res.length(), "");
        return res.toString();
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
}
