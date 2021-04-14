package com.ankushgrover;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Main obj = new Main();
        obj.init();

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
