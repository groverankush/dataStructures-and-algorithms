package com.ankushgrover.problems;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 04/06/20
 *
 * #easy
 */
public class P164LCEReverseString {

    public static void main(String[] args) {


    }

    public void reverseString(char[] s) {

        for(int i = 0 ; i < s.length/2; i++){
            char temp = s[i];
            s[i] = s[s.length-i-1];
            s[s.length-i-1] = temp;
        }

    }
}
