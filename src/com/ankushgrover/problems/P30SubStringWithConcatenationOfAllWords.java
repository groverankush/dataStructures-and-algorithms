package com.ankushgrover.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 */
public class P30SubStringWithConcatenationOfAllWords {

    public static void main(String[] args) {

        String[] arr = {"word","good","best","word"};
        String string = "wordgoodgoodgoodbestword";
        System.out.println(findSubstring(string, arr));
    }

    private static List<Integer> findSubstring(String s, String[] words) {


        List<Integer> result = new ArrayList<>();

        if (s == null || words.length == 0)
            return result;

        HashMap<String, Integer> wordsMap = new HashMap<>();
        createWordMap(wordsMap, words);

        int start = 0;
        int end = words[0].length() * words.length;

        while (end <= s.length()) {

            boolean isFound = true;
            for (int i = 0; i < words.length; i++) {
                int factor = i * words[0].length();
                String sub = s.substring(start + factor, start+ factor + words[0].length());
                Integer count = wordsMap.get(sub);
                if (count == null || count == 0) {
                    start++;
                    end++;
                    isFound = false;
                    break;
                }else{
                    wordsMap.put(sub, --count);
                }
            }
            if (isFound) {
                result.add(start);
                /*start = end;
                end = start + words[0].length() * words.length;*/
                start++;
                end++;
            }

            createWordMap(wordsMap, words);
        }

        return result;

    }

    private static void createWordMap(HashMap<String, Integer> map, String[] words) {
        map.clear();
        for (String word : words) {
            Integer count = map.get(word);

            if (count == null)
                count = 0;

            map.put(word, ++count);
        }
    }
}
