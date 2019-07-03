package com.ankushgrover.algorithms.sort;

import com.ankushgrover.dataStructures.heap.Heap;

import java.util.Arrays;

public class HeapSort {

    private int[] arr;

    public HeapSort(int[] arr) {

        this.arr = arr;

        heapify();
        sort();
    }

    public HeapSort(Heap heap){
        this.arr = heap.getHeap();
        sort();
    }

    private void heapify() {

        for (int i = arr.length - 1; i >= 0; i--) {
            checkDescendants(i, arr.length);
        }
    }

    private void sort() {

        for (int index = arr.length - 1; index > 0; index--) {


            int temp = arr[0];
            arr[0] = arr[index];
            arr[index] = temp;

            checkDescendants(0, index);
        }

    }

    private void checkDescendants(int start, int end) {

        int c1 = start * 2 + 1;
        int c2 = start * 2 + 2;

        int largest = arr[start];
        int index = start;

        if (c1 < end && largest < arr[c1]) {
            index = c1;
            largest = arr[c1];
        }
        if (c2 < end && largest < arr[c2]) {
            index = c2;
        }

        if (index != start) {
            int temp = arr[start];
            arr[start] = arr[index];
            arr[index] = temp;
            checkDescendants(index, end);
        }

    }



}