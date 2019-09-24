package com.ankushgrover.problems;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 23/09/19
 * <p>
 * http://codeforces.com/problemset/problem/239/A
 */
public class P133Div2ATwoBagsOFPotatoes {

    static PrintWriter writer = new PrintWriter(System.out);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokenizer = new StringTokenizer("");

    public static void main(String[] args) throws IOException {

        P133Div2ATwoBagsOFPotatoes obj = new P133Div2ATwoBagsOFPotatoes();
        obj.run();

    }

    static String next() {
        while (!tokenizer.hasMoreTokens())
            try {
                tokenizer = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                return null;
            }
        return tokenizer.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(next());
    }

    private void run() throws IOException {

        //Reader in = new Reader();

        int y = nextInt(), k = nextInt(), n = nextInt();


        long x = k - y % k;
        int l = 0;
        while (x + y <= n) {
            System.out.print(x + " ");
            x += k;
            l = 1;
        }
        if (l == 0) System.out.println(-1);
        /*
        int max = n - y;

        StringBuilder builder = new StringBuilder();

        int sum = 0;
        for (int i = k > y ? k - y : 1; i <= max; i++) {
            if ((i + y) % k == 0) {
                sum = i + y;
                builder.append(i).append(" ");
                break;
            }
        }

        if (sum > 0) {
            sum += k;
            while (sum <= n) {
                builder.append(sum - y).append(" ");
                sum += k;
            }
        }


        System.out.println(builder.length() == 0 ? -1 : builder);*/

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
