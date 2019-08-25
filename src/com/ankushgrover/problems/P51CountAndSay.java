package com.ankushgrover.problems;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 25/08/19
 *
 * https://leetcode.com/problems/count-and-say/
 */
public class P51CountAndSay {

    public static void main(String[] args) {

        System.out.println(countAndSay(6));

    }

    private static String countAndSay(int n) {

        String s = "1";

        for(int i = 1; i < n; i++){

            StringBuilder builder= new StringBuilder();

            int count = 1;
            char ch = s.charAt(0);
            for(int j = 1 ; j < s.length(); j++){
                if(s.charAt(j) == ch){
                    count++;
                }

                else{
                    builder.append(count);
                    builder.append(ch);

                    count = 1;
                    ch = s.charAt(j);
                }

            }

            builder.append(count);
            builder.append(ch);

            s = builder.toString();

        }

        return s;

    }

}
