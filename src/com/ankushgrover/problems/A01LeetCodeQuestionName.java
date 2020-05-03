package com.ankushgrover.problems;

public class A01LeetCodeQuestionName {

    public static void main(String [] args){

        String name = "Ransom Note";

        //1169, 1170, 1171, 1172

        System.out.println(getLeetCodeUrl(name));

    }

    private static String getLeetCodeUrl(String name){

        //https://leetcode.com/problems/number-complement/

        String [] words = name.split(" ");

        StringBuilder builder  = new StringBuilder("https://leetcode.com/problems/");

        for(String word : words){

            builder.append(word.toLowerCase());
            builder.append("-");

        }

        builder.replace(builder.length() - 1, builder.length(), "");

        return builder.toString();

    }

}
