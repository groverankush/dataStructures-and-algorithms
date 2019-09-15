package com.ankushgrover.problems;

import java.util.Scanner;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 14/09/19
 * <p>
 * http://codeforces.com/problemset/problem/445/A
 */
public class P111CFDZYLovesChessBoard {

    public static void main(String[] args) {

        P111CFDZYLovesChessBoard obj = new P111CFDZYLovesChessBoard();
        obj.simple();
    }

    private void simple() {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt(), m = in.nextInt();

        for (int i = 0; i < n; i++) {
            String s = in.next();
            for (int j = 0; j < m; j++) {
                if (s.charAt(j) == '-')
                    System.out.print('-');
                else System.out.print((i + j) % 2 == 0 ? 'B' : 'W');
            }
            System.out.println();
        }
    }

    private void run() {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt(), m = in.nextInt();

        char[][] arr = new char[n][m];

        for (int i = 0; i < n; i++) {
            String str = in.next();
            for (int j = 0; j < str.length(); j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        mark(arr, 0, 0, n, m);

        for (int i = 0; i < n; i++) {
            System.out.println(String.valueOf(arr[i]).replaceAll("V", "-"));
        }
    }

    private void mark(char[][] arr, int i, int j, int n, int m) {

        if (i < 0 || i >= n || j < 0 || j >= m || isVisited(arr, i, j))
            return;

        if (arr[i][j] != '-')
            arr[i][j] = canBeBlack(arr, i, j, n, m) ? 'B' : 'W';
        else arr[i][j] = 'V';

        mark(arr, i, j + 1, n, m);
        mark(arr, i, j - 1, n, m);
        mark(arr, i + 1, j, n, m);
        mark(arr, i - 1, j, n, m);


    }

    private boolean isVisited(char[][] arr, int i, int j) {
        return arr[i][j] == 'B' || arr[i][j] == 'W' || arr[i][j] == 'V';
    }

    private boolean canBeBlack(char[][] arr, int i, int j, int n, int m) {
        return ((j - 1 < 0 || arr[i][j - 1] != 'B') && (j + 1 >= m || arr[i][j + 1] != 'B') && (i - 1 < 0 || arr[i - 1][j] != 'B') && (i + 1 >= n || arr[i + 1][j] != 'B'));
    }
}
