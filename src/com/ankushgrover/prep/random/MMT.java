package com.ankushgrover.prep.random;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 02/07/21
 */
public class MMT {

    public static void main(String[] args) {

        MMT obj = new MMT();
        //obj.main();
        obj.printName();

    }

    private void printName() {

        long millis = System.currentTimeMillis();

        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < 10000; i++) {
            buffer.append("Ankush");
        }

        System.out.println(buffer);
        System.out.println("Time Taken: " + (System.currentTimeMillis() - millis));
    }


    private void main() {

        ThreadExt t1 = new ThreadExt(4, 5);
        ThreadExt t2 = new ThreadExt(5, 6);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
            System.out.println(t1.res + t2.res);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    class ThreadExt extends Thread {

        int i, j, res;

        ThreadExt(int i, int j) {
            this.i = i;
            this.j = j;
        }


        @Override
        public void run() {
            res = i * j;
        }
    }
}
