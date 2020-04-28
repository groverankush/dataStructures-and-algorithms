package com.ankushgrover.problems;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 28/04/20
 * <p>
 * https://leetcode.com/problems/length-of-last-word/
 */
public class P136LCLengthOfLastWord {

    public static void main(String[] args) {
        P136LCLengthOfLastWord obj = new P136LCLengthOfLastWord();
        System.out.println(obj.lengthOfLastWord("Hello"));
    }


    int lengthOfLastWord(String s) {

        String arr[] = s.split(" ");
        if (arr.length > 1)
            return arr[arr.length - 1].length();
        return 0;

    }
}
