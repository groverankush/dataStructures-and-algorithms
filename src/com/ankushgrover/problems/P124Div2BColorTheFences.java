package com.ankushgrover.problems;

import javafx.util.Pair;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 21/09/19
 * <p>
 * http://codeforces.com/problemset/problem/349/B
 */
public class P124Div2BColorTheFences {

    public static void main(String[] args) throws IOException {

        P124Div2BColorTheFences obj = new P124Div2BColorTheFences();
        obj.run();
    }

    private void run() throws IOException {
        Reader in = new Reader();

        int paint = in.nextInt();

        List<Pair<Integer, Integer>> pairs = new ArrayList<>(9);

        int min = Integer.MAX_VALUE, index = -1;

        for (int i = 0; i < 9; i++) {

            Pair<Integer, Integer> pair = new Pair<>(i + 1, in.nextInt());
            pairs.add(pair);
            if (pair.getValue() <= min) {
                min = pair.getValue();
                index = i + 1;
            }

        }

        pairs.sort(new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> integerIntegerPair, Pair<Integer, Integer> t1) {
                return t1.getValue() - integerIntegerPair.getValue();
            }
        });

        StringBuilder builder = new StringBuilder();

        while (paint >= 2 * min) {

            builder.append(index);
            paint = paint - min;

        }

        for (int i = 8; i >= 0; i--) {

            if (pairs.get(i).getValue() <= paint && pairs.get(i).getKey() >= index) {
                builder.insert(0, pairs.get(i).getKey());
                break;
            }

        }

        if (builder.length() == 0)
            builder.append("-1");
        System.out.println(builder);

    }

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }


    }

}
