package com.ankushgrover.prep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 27/07/21
 */
public class I56GFGHAlienDictionary {

    public static void main(String[] args) {

        I56GFGHAlienDictionary obj = new I56GFGHAlienDictionary();
        String[] arr = {"baa", "abcd", "abca", "cab", "cad"};
        int n = 5;
        int k = 4;
        System.out.println(obj.findOrder(arr, n, k));

    }

    public String findOrder(String[] dict, int N, int K) {

        HashMap<Character, List<Character>> map = createGraph(dict);

        HashSet<Character> visited = new HashSet<>();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < K; i++) {
            char ch = (char) ('a' + i);
            if (!visited.contains(ch)) {
                dfs(ch, map, visited, builder);
            }
        }

        return builder.toString();

    }

    private void dfs(char ch, HashMap<Character, List<Character>> map, HashSet<Character> visited, StringBuilder builder) {

        if (visited.contains(ch))
            return;

        visited.add(ch);

        List<Character> list = map.getOrDefault(ch, new ArrayList<>());

        for (char cur : list) {
            dfs(cur, map, visited, builder);
        }

        builder.insert(0, ch);

    }

    private HashMap<Character, List<Character>> createGraph(String[] dict) {

        HashMap<Character, List<Character>> map = new HashMap<>();

        for (int i = 0; i < dict.length - 1; i++) {
            String word1 = dict[i];
            String word2 = dict[i + 1];
            char[] pair = compare(word1, word2);

            if (pair != null) {
                List<Character> list = map.get(pair[0]);
                if (list == null) {
                    list = new ArrayList<Character>();
                    map.put(pair[0], list);
                }
                list.add(pair[1]);
            }
        }

        return map;

    }

    private char[] compare(String word1, String word2) {

        int i;
        int l1 = word1.length(), l2 = word2.length();
        int min = Math.min(l1, l2);

        for (i = 0; i < min; i++) {
            char ch1 = word1.charAt(i);
            char ch2 = word2.charAt(i);

            if (ch1 != ch2)
                return new char[]{ch1, ch2};
        }


        return null;

    }
}
