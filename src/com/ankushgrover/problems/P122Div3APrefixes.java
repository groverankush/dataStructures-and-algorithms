package com.ankushgrover.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 20/09/19
 * <p>
 * https://codeforces.com/contest/1216/problem/0
 */
public class P122Div3APrefixes {

    public static void main(String[] args) {
        P122Div3APrefixes obj = new P122Div3APrefixes();
        obj.run();
    }

    private void run() {
        MyScanner in = new MyScanner();

        int size = in.nextInt();
        String s = in.next();

        StringBuilder b = new StringBuilder();

        int count = 0;

        for (int i = 0; i < s.length() - 1; i += 2) {

            if (s.charAt(i) == s.charAt(i + 1)) {
                b.append(s.charAt(i));
                b.append(s.charAt(i) == 'a' ? 'b' : 'a');
                count++;
            } else {
                b.append(s.charAt(i));
                b.append(s.charAt(i + 1));
            }

        }
        String str = "" + count + "\n";
        b.insert(0, str);
        System.out.println(b);

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

