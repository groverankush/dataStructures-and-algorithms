package com.ankushgrover.prep;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 24/05/21
 * <p>
 * https://leetcode.com/problems/design-tic-tac-toe/
 */
public class I31LCMDesignTicTacToe {

    private int n;
    private int[][] records;
    private int moves;

    I31LCMDesignTicTacToe(int n) {
        this.n = n;
        moves = 0;
        records = new int[2][n + n + 2];
    }

    public static void main(String[] args) {

    }

    /**
     * @param row
     * @param col
     * @param player
     * @return 0: No one Wins
     * 1: Player 1 Wins
     * 2: Player 2 Wins
     */
    public int move(int row, int col, int player) {

        int[] arr = records[player - 1];

        arr[row] += 1;
        arr[n + col] += 1;
        manageDiagnals(arr, row, col);


        if (arr[row] == n || arr[col] == n || arr[arr.length - 1] == n || arr[arr.length - 2] == n)
            return player;

        return 0;

    }

    private void manageDiagnals(int[] arr, int row, int col) {
        if (row == col)
            arr[arr.length - 2] += 1;
        if (row + col == n - 1)
            arr[arr.length - 1] += 1;
    }


}
