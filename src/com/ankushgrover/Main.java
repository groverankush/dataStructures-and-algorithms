package com.ankushgrover;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        /*Main obj = new Main();
        obj.init()*/
        ;

        int[] x = {2, 2, 2, 2, 1, 1, 1, 1};
        int k = 1;
        System.out.println(hackerlandRadioTransmitters(x, k));

    }

    static int hackerlandRadioTransmittersOld(int[] x, int k) {
        Arrays.sort(x);

        int i = 0;
        int n = x.length;
        int count = 0;

        while (i < n) {

            count++;

            int loc = x[i] + k;

            while (i < n && x[i] <= loc) i++;

            loc = x[--i] + k;

            while (i < n && x[i] <= loc) i++;

        }

        return count;
    }

    static int hackerlandRadioTransmitters(int[] x, int k) {


        int i = 0;
        int power = k;
        int count = 0;

        Arrays.sort(x);

        while (i < x.length - 1) {

            int diff = x[i + 1] - x[i];

            if (diff > power) {
                count++;
                power = k;
            } else {
                power = power - diff;
            }

            i++;
        }

        return count;
    }


    private void init() {

        ArrayList<Sample> list = new ArrayList<>();

        list.add(new Sample());

        list.addAll(list);
        list.addAll(list);
        list.addAll(list);
        list.addAll(list);
        list.addAll(list);
        list.addAll(list);


        System.out.println(list.toString());
    }

    class Sample {

        boolean b = true;

        @Override
        public String toString() {
            return String.valueOf(b);

        }
    }
}
