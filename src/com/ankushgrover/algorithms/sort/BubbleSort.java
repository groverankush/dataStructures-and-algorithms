package com.ankushgrover.algorithms.sort;

public class BubbleSort {

    private int[] arr;
    private long startTime;


    public BubbleSort(int[] arr) {
        this.arr = arr;

        startTime = System.nanoTime();

        sort();

    }

    private void sort() {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

            }
        }

        System.out.println("Time: " + (System.nanoTime() - startTime));
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i : arr) {
            builder.append(i).append(",");
        }
        return builder.toString();
    }


}
