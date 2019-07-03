package com.ankushgrover.algorithms.sort;

public class MergeSort {

    private int[] arr;

    public MergeSort(int[] arr) {

        this.arr = arr;

        sort(0, arr.length-1);

    }


    private void sort(int start, int end) {

        if (start < end) {


            int mid = (start + end) / 2;

            sort(start, mid);
            sort(mid + 1, end);
            merge(start, mid, end);

        }
    }

    private void merge(int start, int mid, int end) {

        int[] temp1 = new int[mid - start + 1];
        int[] temp2 = new int[end - mid];

        for (int i = 0; i < mid - start + 1; i++) {
            temp1[i] = arr[start + i];
        }

        for (int i = 0; i < end - mid; i++) {
            temp2[i] = arr[mid + i + 1];
        }
        int i = 0, j = 0, count = start;

        while (i < temp1.length && j < temp2.length) {

            if (temp1[i] < temp2[j])
                arr[count++] = temp1[i++];
            else
                arr[count++] = temp2[j++];

        }

        while (i < temp1.length)
            arr[count++] = temp1[i++];

        while (j < temp2.length)
            arr[count++] = temp2[j++];


    }


}

