package com.ankushgrover.algorithms.sort;

public class SelectionSort {

    private int [] arr;
    private long startTime;


    public SelectionSort(int [] arr  ){
        this.arr = arr;
        startTime = System.nanoTime();

        sort();
    }

    private void sort(){

        for(int i = 0 ; i < arr.length; i++){
            int selectedIndex = i;
            for (int j = i+1; j <arr.length; j++){
                if(arr[selectedIndex] > arr[j]){
                    selectedIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[selectedIndex];
            arr[selectedIndex] = temp;
        }

        System.out.println("Time: " + (System.nanoTime() - startTime));
    }

}
