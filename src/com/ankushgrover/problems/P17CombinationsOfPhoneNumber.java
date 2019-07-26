package com.ankushgrover.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class P17CombinationsOfPhoneNumber {


    public static void main(String[] args) {
        System.out.println(combinations("23"));
    }

    private static List<String> combinations(String str) {

        if (str.isEmpty()) {
            List<String> l = new ArrayList<String>();
            l.add("");
            return l;
        }


        char ch = str.charAt(0);
        String ros = str.substring(1);
        List<String> list = combinations(ros);
        List<String> result = new ArrayList<>();

        switch (ch) {
            case '2':
                for (String s : list) {
                    result.add('a' + s);
                    result.add('b' + s);
                    result.add('c' + s);
                }
                break;
            case '3':
                for (String s : list) {
                    result.add('d' + s);
                    result.add('e' + s);
                    result.add('f' + s);
                }
                break;
            case '4':
                for (String s : list) {
                    result.add('g' + s);
                    result.add('h' + s);
                    result.add('i' + s);
                }
                break;
            case '5':
                for (String s : list) {
                    result.add('j' + s);
                    result.add('k' + s);
                    result.add('l' + s);
                }
                break;
            case '6':
                for (String s : list) {
                    result.add('m' + s);
                    result.add('n' + s);
                    result.add('o' + s);
                }
                break;
            case '7':
                for (String s : list) {
                    result.add('p' + s);
                    result.add('q' + s);
                    result.add('r' + s);
                    result.add('s' + s);
                }
                break;
            case '8':
                for (String s : list) {
                    result.add('t' + s);
                    result.add('u' + s);
                    result.add('v' + s);
                }
                break;
            case '9':
                for (String s : list) {
                    result.add('w' + s);
                    result.add('x' + s);
                    result.add('y' + s);
                    result.add('z' + s);
                }
                break;

        }

        return result;
    }
}
