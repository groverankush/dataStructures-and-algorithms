package com.ankushgrover.problems;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 17/06/20
 * <p>
 * #medium #dfs
 */
public class P172LCMSurroundedRegions {

    public static void main(String[] args) {
    }

    public void solve(char[][] board) {


        for (int i = 0; i < board.length; i++) {

            if (i == 0 || i == board.length - 1) {

                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == 'O')
                        dfs(board, i, j);
                }

            } else {
                if (board[i][0] == 'O')
                    dfs(board, i, 0);
                if (board[i][board[i].length - 1] == 'O')
                    dfs(board, i, board[i].length - 1);
            }

        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'o')
                    board[i][j] = 'O';
                else board[i][j] = 'X';
            }
        }

    }

    private void dfs(char[][] visited, int i, int j) {

        visited[i][j] = 'o';

        int[] ds = {-1, 1, 0, 0};

        for (int x = 0; x < 4; x++) {
            if (isValid(visited, i + ds[x], j + ds[4 - x - 1])) {
                dfs(visited, i + ds[x], j + ds[4 - x - 1]);
            }
        }


    }

    private boolean isValid(char[][] visited, int i, int j) {
        return i >= 0 && i < visited.length && j >= 0 && j < visited[0].length && visited[i][j] == 'O';
    }
}
