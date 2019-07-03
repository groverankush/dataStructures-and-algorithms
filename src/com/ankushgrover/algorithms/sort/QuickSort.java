package com.ankushgrover.algorithms.sort;

public class QuickSort {

    private int[] arr;

    public QuickSort(int[] arr) {

        this.arr = arr;

        long startTime = System.nanoTime();


        sort(0, arr.length - 1);

        System.out.println("Time: " + (System.nanoTime() - startTime));

    }


    private int partition(int start, int end) {
        int index = start;

        for (int i = start; i < end; i++) {


            if (arr[i] <= arr[end]) {
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index++] = temp;
            }

        }
        int temp = arr[end];
        arr[end] = arr[index];
        arr[index] = temp;

        return index;
    }

    private void sort(int start, int end) {

        if (start >= end)
            return;

        int index = partition(start, end);
        sort(start, index - 1);
        sort(index + 1, end);

    }

}

