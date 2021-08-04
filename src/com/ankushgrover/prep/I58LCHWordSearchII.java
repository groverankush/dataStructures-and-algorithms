package com.ankushgrover.prep;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 30/07/21
 */
public class I58LCHWordSearchII {

    public static void main(String[] args) {

        I58LCHWordSearchII obj = new I58LCHWordSearchII();
        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = {"oath", "pea", "eat", "rain"};
        System.out.println(obj.findWords(board, words));

    }

    public List<String> findWords(char[][] board, String[] words) {

        Node root = makeTrie(words);

        List<String> res = new ArrayList<>();


        search(board, root, res);

        return res;
    }

    private Node makeTrie(String[] words) {

        Node root = new Node();

        for (String word : words) {
            Node node = root;

            for (char c : word.toCharArray()) {
                int i = c - 'a';
                if (node.arr[i] == null) {
                    node.arr[i] = new Node();
                }
                node = node.arr[i];
            }
            node.word = word;
        }

        return root;

    }

    private void search(char board[][], Node root, List<String> res) {


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res);
            }
        }

    }

    private void dfs(char[][] board, int x, int y, Node node, List<String> res) {

        char ch = board[x][y];

        if (ch == '*' || node == null || node.arr[ch - 'a'] == null)
            return;

        int i = ch - 'a';


        if (node.arr[i].word != null) {
            res.add(node.arr[i].word);
            node.arr[i].word = null;
        }


        int l = board.length;
        int m = board[0].length;

        board[x][y] = '*';

        if (x + 1 < l) dfs(board, x + 1, y, node.arr[i], res);
        if (x - 1 >= 0) dfs(board, x - 1, y, node.arr[i], res);
        if (y + 1 < m) dfs(board, x, y + 1, node.arr[i], res);
        if (y - 1 >= 0) dfs(board, x, y - 1, node.arr[i], res);

        board[x][y] = ch;


    }

    class Node {
        String word;
        Node[] arr = new Node[26];
    }
}
