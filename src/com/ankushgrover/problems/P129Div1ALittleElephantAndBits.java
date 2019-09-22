package com.ankushgrover.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 22/09/19
 * <p>
 * http://codeforces.com/problemset/problem/258/A
 */
public class P129Div1ALittleElephantAndBits {

    public static void main(String[] args) {

        P129Div1ALittleElephantAndBits obj = new P129Div1ALittleElephantAndBits();
        obj.run();
    }

    private void run() {

        MyScanner in = new MyScanner();
        StringBuilder builder = new StringBuilder(in.next());
        int i, size = builder.length();
        for (i = 0; i < builder.length(); i++) {
            if (builder.charAt(i) == '0') {
                builder.replace(i, i + 1, "");
                break;
            }
        }

        if (i == size) {
            builder.replace(builder.length() - 1, builder.length(), "");
        }

        System.out.println(builder.length() == 0 ? 0 : builder);
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
