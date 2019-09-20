package com.ankushgrover.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 19/09/19
 * <p>
 * http://codeforces.com/problemset/problem/433/A
 */
public class P121CFDiv2AKitaharaHarukiGift {

    public static void main(String[] args) {

        P121CFDiv2AKitaharaHarukiGift obj = new P121CFDiv2AKitaharaHarukiGift();
        obj.run();
    }

    private void run() {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int a1 = 0, a2 = 0, as = 0;

        for (int i = 0; i < n; i++) {

            int num = in.nextInt();

            as += num;
            if (num == 100)
                a1++;
            else a2++;
        }

        if (n == 1)
            System.out.println("NO");
        else if (a1 % 2 == 0 && a2 % 2 == 0)
            System.out.println("YES");
        else if (a1 % 2 != 0 && a2 % 2 == 0 && a1 != 0 && a2 != 0)
            System.out.println("NO");
        else if (a1 % 2 == 0 && a2 % 2 != 0 && a1 != 0 && a2 != 0)
            System.out.println("YES");

        else System.out.println("NO");


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
