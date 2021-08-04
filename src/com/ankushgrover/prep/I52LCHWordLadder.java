package com.ankushgrover.prep;

import java.util.*;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 13/07/21
 */
public class I52LCHWordLadder {

    public static void main(String[] args) {
        I52LCHWordLadder obj = new I52LCHWordLadder();

        String beginWord = "hit";
        String endWord = "cog";
        List<String> words = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));

        System.out.println(obj.ladderLength(beginWord, endWord, words));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        return bfsApproach(beginWord, endWord, wordList);
    }

    private int bfsApproach(String beginWord, String endWord, List<String> wordList) {

        HashMap<String, List<String>> graph = makeGraph(beginWord, wordList);
        return bfs(beginWord, endWord, graph);


    }


    private int bfs(String beginWord, String endWord, HashMap<String, List<String>> graph) {

        HashSet<String> visited = new HashSet<>();

        int length = 0;

        Stack<String> s1 = new Stack<String>();
        Stack<String> s2 = new Stack<String>();

        s1.push(beginWord);

        while (!s1.isEmpty() || !s2.isEmpty()) {
            Stack<String> s = s1.isEmpty() ? s2 : s1;
            Stack<String> other = s1.isEmpty() ? s1 : s2;

            length++;


            while (!s.isEmpty()) {

                String word = s.pop();

                if (!visited.contains(word)) {

                    if (word.equals(endWord)) {
                        return length;
                    }

                    List<String> words = graph.get(word);
                    for (String w : words) {
                        other.push(w);
                    }

                    visited.add(word);

                }

            }

        }

        return 0;


    }

    private HashMap<String, List<String>> makeGraph(String beginWord, List<String> wordList) {

        HashMap<String, List<String>> map = new HashMap<>();

        List<String> edges = createEdgesForVertex(beginWord, wordList);

        map.put(beginWord, edges);

        for (String word : wordList) {

            edges = createEdgesForVertex(word, wordList);
            map.put(word, edges);

        }

        return map;


    }

    private List<String> createEdgesForVertex(String beginWord, List<String> wordList) {

        List<String> res = new ArrayList<>();

        for (String word : wordList) {

            int count = 0;

            for (int i = 0; i < word.length(); i++) {

                if (beginWord.charAt(i) != word.charAt(i)) {
                    count++;
                }
            }

            if (count == 1)
                res.add(word);

        }

        return res;

    }
}
