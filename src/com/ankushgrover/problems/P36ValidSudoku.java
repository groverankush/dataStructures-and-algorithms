package com.ankushgrover.problems;

import java.util.HashMap;

public class P36ValidSudoku {

    public static void main(String[] args) {
    }

    private static boolean isValidSudoku02(char[][] board) {

        int[] vset = new int[9];
        int[] hset = new int[9];
        int[] bckt = new int[9];
        int idx = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    idx = 1 << (board[i][j] - '0');
                    if ((hset[i] & idx) > 0 ||
                            (vset[j] & idx) > 0 ||
                            (bckt[(i / 3) * 3 + j / 3] & idx) > 0) return false;
                    hset[i] |= idx;
                    vset[j] |= idx;
                    bckt[(i / 3) * 3 + j / 3] |= idx;
                }
            }
        }
        return true;

    }

    private static boolean isValidSudoku01(char[][] board) {
        return checkRows(board) && checkColumns(board) && checkMiniGrids(board);
    }

    private static boolean checkRows(char[][] board) {


        for (int i = 0; i < 9; i++) {

            HashMap<Character, Integer> map = new HashMap<>();


            for (int j = 0; j < 9; j++) {

                if (board[i][j] != '.') {

                    Integer count = map.getOrDefault(board[i][j], 0);
                    if (count == 1)
                        return false;
                    map.put(board[i][j], ++count);

                }

            }

        }

        return true;

    }

    private static boolean checkColumns(char[][] board) {

        char ch;

        for (int i = 0; i < 9; i++) {

            HashMap<Character, Integer> map = new HashMap<>();


            for (int j = 0; j < 9; j++) {
                ch = board[j][i];
                if (ch != '.') {

                    Integer count = map.getOrDefault(ch, 0);
                    if (count == 1)
                        return false;
                    map.put(ch, ++count);

                }

            }

        }

        return true;
    }

    private static boolean checkMiniGrids(char[][] board) {

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {

                char ch;
                HashMap<Character, Integer> map = new HashMap<>();


                for (int k = 0; k < 3; k++) {

                    for (int l = 0; l < 3; l++) {

                        ch = board[i + k][j + l];

                        if (ch != '.') {

                            Integer count = map.getOrDefault(ch, 0);
                            if (count == 1)
                                return false;
                            map.put(ch, ++count);

                        }
                    }

                }

            }
        }

        return true;

    }
}
