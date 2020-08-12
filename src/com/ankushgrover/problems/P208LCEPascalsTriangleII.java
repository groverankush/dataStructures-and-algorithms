package com.ankushgrover.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 12/08/20
 */
public class P208LCEPascalsTriangleII {

    public static void main(String[] args) {
    }


    public List<Integer> getRow(int rowIndex) {
        List<Integer> space = new ArrayList<>();
        space.add(1);

        if (rowIndex == 0)
            return space;

        space.add(1);

        if (rowIndex == 1)
            return space;

        for (int i = 0; i < rowIndex; i++) {

            int prev = space.get(0);
            for (int j = 1; j < space.size(); j++) {
                int temp = prev;
                space.set(j, prev + space.get(j));
                prev = temp;
            }
            space.add(1);

        }
        return space;
    }
}
