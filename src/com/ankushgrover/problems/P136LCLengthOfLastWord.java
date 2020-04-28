package com.ankushgrover.problems;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 28/04/20
 * <p>
 * https://leetcode.com/problems/length-of-last-word/
 */
public class P136LCLengthOfLastWord {

    public static void main(String[] args) {
        P136LCLengthOfLastWord obj = new P136LCLengthOfLastWord();
        System.out.println(obj.lengthOfLastWord02("world"));
    }


    private int lengthOfLastWord(String s) {

        String arr[] = s.split(" ");
        if (arr.length > 1)
            return arr[arr.length - 1].length();
        return 0;

    }

    private int lengthOfLastWord02(String s) {

        int count = 0;
        int i = s.length()-1;
        while(i >= 0){
            if  (s.charAt(i) == ' ')
                i--;
            else break;
        }
        for (; i >= 0 && s.charAt(i) != ' '; i--) {
            count++;
        }
        return count;
    }
}
