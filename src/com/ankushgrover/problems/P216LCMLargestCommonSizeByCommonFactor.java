package com.ankushgrover.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 30/08/20
 */
public class P216LCMLargestCommonSizeByCommonFactor {

    public static void main(String[] args) {
    }

    public int largestComponentSize(int[] A) {

        List<Component> com = new ArrayList<>();
        boolean isAllN = false;

        com.add(new Component(A[0]));
        A[0] = -1;
        return 0;

    }

    private void checkComponents(List<Component> list) {

    }

    class Component {

        int value = 1;
        HashSet<Integer> set;

        Component(int value) {
            set = new HashSet<>();
            set.add(value);
            this.value = value;
        }


    }
}
