package com.ankushgrover.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 22/09/19
 * <p>
 * http://codeforces.com/problemset/problem/186/A
 */
public class P126Div2ACompairingStrings {

    public static void main(String[] args) {
        P126Div2ACompairingStrings obj = new P126Div2ACompairingStrings();


        obj.run();
    }

    private void run() {

        MyScanner in = new MyScanner();

        String s1 = in.next();
        String s2 = in.next();


        if (s1.length() != s2.length()) {
            System.out.println("NO");
            return;
        }

        int i1 = -1;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < s1.length() && list.size() < 3; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                list.add(i);
            }
        }

        if (list.size() == 2) {
            if (s1.charAt(list.get(0)) == s2.charAt(list.get(1)) && s1.charAt(list.get(1)) == s2.charAt(list.get(0)))
                System.out.println("YES");
            else System.out.println("NO");
        } else {
            System.out.println("NO");
        }
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
