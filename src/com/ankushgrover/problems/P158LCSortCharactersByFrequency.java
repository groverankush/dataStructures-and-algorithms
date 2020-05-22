package com.ankushgrover.problems;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 22/05/20
 * <p>
 * https://leetcode.com/problems/sort-characters-by-frequency/
 */
public class P158LCSortCharactersByFrequency {

    public static void main(String[] args) {

        P158LCSortCharactersByFrequency obj = new P158LCSortCharactersByFrequency();
        System.out.println(obj.frequencySort("Aabb"));

    }

    public String frequencySort(String s) {

        HashMap<Character, Node> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            Node node = map.getOrDefault(ch, null);
            if (node == null) {
                node = new Node(ch, 1);
                map.put(ch, node);
            } else node.count++;
        }


        ArrayList<Node> list = new ArrayList<>();

        for (char ch : map.keySet()) {
            Node node = map.get(ch);
            list.add(node);
        }

        list.sort((node, t1) -> t1.count - node.count);

        StringBuilder builder = new StringBuilder();
        for (Node node : list) {
            builder.append(String.valueOf(node.ch).repeat(Math.max(0, node.count)));
        }

        return builder.toString();
    }

    class Node {

        public char ch;
        public int count;

        public Node(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }

    }


}
