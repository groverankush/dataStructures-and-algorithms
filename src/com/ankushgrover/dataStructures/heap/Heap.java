package com.ankushgrover.dataStructures.heap;

public class Heap {

    private int[] arr;
    private int last;

    public Heap(int size) {

        this.arr = new int[size];
        last = 0;

    }

    public void add(int element) {

        this.arr[last++] = element;

    }

    private void heapify(int index) {

        int parent = (int) Math.ceil(index / 2.0) - 1;

        String s;

    }

}
