package com.ankushgrover.prep;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 23/05/21
 */
public class I29LCMRandomizeSet {

    private HashMap<Integer, Integer> valIndexMap = new HashMap<>();
    private int[] arr = new int[10];
    private int arrTop = 0;
    private Random random = new Random();

    /**
     * Initialize your data structure here.
     */
    public I29LCMRandomizeSet() {

    }

    public static void main(String[] args) {

        I29LCMRandomizeSet obj = new I29LCMRandomizeSet();
        System.out.println(obj.remove(0));
        System.out.println(obj.remove(0));
        System.out.println(obj.insert(0));
        System.out.println(obj.getRandom());
        System.out.println(obj.remove(0));
        System.out.println(obj.insert(0));
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {

        if (valIndexMap.containsKey(val))
            return false;

        expandIfRequired();

        arr[arrTop] = val;
        valIndexMap.put(val, arrTop);
        ++arrTop;
        return true;
    }

    private void expandIfRequired() {
        if (shouldExpand()) {

            int[] temp = new int[arr.length * 2];
            for (int i = 0; i < arr.length; i++) {
                temp[i] = arr[i];
            }
            arr = temp;

        }
    }

    private boolean shouldExpand() {
        return arrTop == arr.length;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        Integer index = valIndexMap.remove(val);

        if (index == null) {
            return false;
        }
        int element = arr[--arrTop];

        if (index != arrTop) {
            arr[index] = element;

            valIndexMap.put(element, index);
        }


        return true;

    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        int index = random.nextInt(arrTop);
        return arr[index];
    }
}
