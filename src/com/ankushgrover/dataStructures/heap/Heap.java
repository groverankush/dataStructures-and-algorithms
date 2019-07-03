package com.ankushgrover.dataStructures.heap;

import java.util.Arrays;

public class Heap {

    private int[] arr;
    private int index;

    public Heap(int size) {
        this.arr = new int[size];
        this.index = 0;
    }

    private boolean isFull() {

        return index == arr.length;

    }

    public void add(int element) {

        if (isFull())
            return;

        arr[index] = element;
        adjustHeap(index++);
    }

    private void adjustHeap(int index) {

        if (index <= 0)
            return;

        int parent = (int) Math.ceil(index / 2.0) - 1;

        if (arr[parent] < arr[index]) {

            int temp = arr[index];
            arr[index] = arr[parent];
            arr[parent] = temp;

            adjustHeap(parent);
        }


    }

    public String toString() {

        return "Heap is" + Arrays.toString(arr);
    }

}