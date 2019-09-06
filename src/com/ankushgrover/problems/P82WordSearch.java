package com.ankushgrover.problems;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 06/09/19
 * <p>
 * https://leetcode.com/problems/word-search/
 */
public class P82WordSearch {

    public static void main(String[] args) {

        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCEFSADEESE";

/*        char [][] board = {{'a','a'}};
        String word = "aaa";*/

        System.out.println(exist(board, word));
    }

    private static boolean exist(char[][] board, String word) {

        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j] && search(board, visited, i, j, 0, word))
                    return true;
            }
        }
        return false;
    }

/*    private static boolean [][] getVisited(char [][] board){
        return new boolean[board.length][board[0].length];
    }*/

    private static boolean search(char[][] board, boolean[][] visited, int i, int j, int index, String word) {


        if (index >= word.length())
            return true;

        if (i >= board.length || i < 0 || j >= board[0].length || j < 0)
            return false;

        if (visited[i][j]) return false;

        visited[i][j] = true;

        boolean ret = false;
        if (board[i][j] == word.charAt(index)) {

            if (search(board, visited, i, j + 1, index + 1, word)
                    || search(board, visited, i + 1, j, index + 1, word)
                    || search(board, visited, i, j - 1, index + 1, word)
                    || search(board, visited, i - 1, j, index + 1, word)) {
                ret = true;
            }

        }

        visited[i][j] = false;


        return ret;

    }
}
