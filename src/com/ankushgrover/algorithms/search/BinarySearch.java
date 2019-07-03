package com.ankushgrover.algorithms.search;

public class BinarySearch {

    private int[] arr;

    public BinarySearch(int[] arr) {
        this.arr = arr;
    }

    public int searchIterative(int element) {
        int low = 0;
        int high = arr.length;


        while (low < high) {

            int mid = (low + high) / 2;

            if (arr[mid] == element)
                return mid;


            if (arr[mid] < element) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return -1;
    }

    public int searchRecursive(int element) {
        return search(element, 0, arr.length);
    }

    private int search(int element, int low, int high) {
        if (low == high)
            return -1;

        int mid = (low + high) / 2;


        if (arr[mid] == element)
            return mid;

        if (arr[mid] < element) {
            low = mid + 1;
        } else
            high = mid;

        return search(element, low, high);
    }

}
