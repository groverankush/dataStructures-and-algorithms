package com.ankushgrover.prep;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 23/05/21
 */
public class I30LCMFlatten2DVector {

    int outer = 0;
    int inner = 0;
    List<List<Integer>> vec;

    public I30LCMFlatten2DVector(List<List<Integer>> vec2d) {
        // Initialize your data structure here
        this.vec = vec2d;
    }

    public static void main(String[] args) {

        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(1);
        temp.add(2);
        list.add(temp);
        list.add(new ArrayList<>());

        I30LCMFlatten2DVector obj = new I30LCMFlatten2DVector(list);
        System.out.println(obj.next());
        System.out.println(obj.next());
    }

    public Integer next() {
        // Write your code here

        if (!hasNext())
            return null;

        int element = vec.get(outer).get(inner);
        inner++;
        return element;


    }

    private void arrange() {

        while (outer < vec.size()) {

            if (inner < vec.get(outer).size()) {
                return;
            }

            outer++;
            inner = 0;

        }
    }


    public boolean hasNext() {
        // Write your code here
        arrange();

        return (outer < vec.size() && inner < vec.get(outer).size());
    }
}
