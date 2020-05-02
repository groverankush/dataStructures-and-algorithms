package com.ankushgrover.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 02/05/20
 *
 * https://codeforces.com/problemset/problem/141/A
 */
public class P141CFAAmusingJoke {



    public static void main(String[] args) {
        P141CFAAmusingJoke obj = new P141CFAAmusingJoke();
        obj.run();
    }

    private void run(){
        MyScanner scanner = new MyScanner();
        String first = scanner.next();
        String second = scanner.next();
        String third = scanner.next();

        byte [] arr = new byte[26];

        for(int i = 0; i < first.length(); i++){
            int index = first.charAt(i) - 'A';
            arr[index] = ++arr[index];
        }

        for(int i = 0; i < second.length(); i++){
            int index = second.charAt(i) - 'A';
            arr[index] = ++arr[index];
        }

        for(int i = 0; i < third.length(); i++){
            int index = third.charAt(i) - 'A';
            arr[index] = --arr[index];
        }

        for (byte b : arr) {
            if (b != 0) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");

    }

    public static class MyScanner {
        BufferedReader reader;

        public MyScanner() {
            this.reader = new BufferedReader(new InputStreamReader(System.in));
        }

        public void close() throws IOException {
            this.reader.close();
        }

        int nextInt() {
            return Integer.parseInt(this.next());
        }

        long nextLong() {
            return Long.parseLong(this.next());
        }

        double nextDouble() {
            return Double.parseDouble(this.next());
        }

        String next() {
            String str = "";
            try {
                str = this.reader.readLine().trim();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        String[] nextStringArray() {
            String[] str = null;
            try {
                str = this.reader.readLine().trim().split(" ");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int[] nextIntArray() {
            String[] data = nextStringArray();
            int[] a = new int[data.length];

            for (int i = 0; i < a.length; i++) {
                a[i] = Integer.parseInt(data[i]);
            }

            return a;
        }

        Integer[] nextIntegerArray() {
            String[] data = nextStringArray();
            Integer[] a = new Integer[data.length];

            for (int i = 0; i < a.length; i++) {
                a[i] = Integer.parseInt(data[i]);
            }

            return a;
        }

        long[] nextLongArray() {
            String[] data = nextStringArray();
            long[] a = new long[data.length];

            for (int i = 0; i < a.length; i++) {
                a[i] = Long.parseLong(data[i]);
            }

            return a;
        }
    }

}
