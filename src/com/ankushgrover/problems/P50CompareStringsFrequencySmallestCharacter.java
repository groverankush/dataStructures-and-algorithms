package com.ankushgrover.problems;

import java.util.Arrays;

/**
 *
 */
public class P50CompareStringsFrequencySmallestCharacter {

    public static void main(String [] args){

        String [] arr = {"bbb","cc"};
        String q [] = {"a","aa","aaa","aaaa"};
        System.out.println(Arrays.toString(numSmallerByFrequency(arr, q)));

    }

    private static int[] numSmallerByFrequency(String[] queries, String[] words) {

        int [] ql = new int[queries.length];
        int [] wl = new int[words.length];

        for(int i = 0 ; i < words.length; i++){
            wl[i] = getFrequency(words[i]);
        }

        for(int i = 0 ; i < queries.length; i++){
            int frequency  = getFrequency(queries[i]);

            int count = 0;

            for(int j = 0 ; j < wl.length; j++){
                if(frequency < wl[j])
                    count++;
            }

            ql[i] = count;
        }

        return ql;

    }

    private static int getFrequency(String word){

        char min = 'z';

        for(int i = 0; i < word.length(); i++){

            if(word.charAt(i) < min)
                min = word.charAt(i);
        }

        int count = 0;

        for(int i = 0 ; i < word.length(); i++){
            if(word.charAt(i) == min)
                count++;
        }

        return count;

    }

}
