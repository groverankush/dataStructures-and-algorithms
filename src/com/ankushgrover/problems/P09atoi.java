package com.ankushgrover.problems;

import java.util.regex.Pattern;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 */
public class P09atoi {

    public static void main(String[] args) {
        
        System.out.println(myAtoi("2147483646"));
    }

    private static int myAtoi(String str) {


        // Discard white spaces
        // optional + or -
        // ignore chars after number
        // discard string with initial chars


        str = str.trim();

        if (!Pattern.matches("[+-]?[0-9]+[.]?.*", str))
            return 0;

        int i = 0;

        byte isNegative = 0;
        long result = 0;

        if(str.charAt(0) == '+'){
            i++;
        }else if( str.charAt(0) == '-'){
            i++;
            isNegative = 1;
        }


        while (i < str.length()) {
            char ch = str.charAt(i);


            if (!Character.isDigit(ch))
                return (int) ((result / 10) * (isNegative == 0 ? 1L : -1L));

            else {
                result = result + ch - '0';
                if (result > Integer.MAX_VALUE)
                    return isNegative == 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                result = result * 10;
            }
            i++;
        }

        result = (result / 10) * (isNegative == 0 ? 1L : -1L);

        return (int) result;


    }
}
