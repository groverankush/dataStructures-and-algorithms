package com.ankushgrover.problems;

public class P33WhacAMole {

    public static void main(String[] args) {
        int holes[] = {1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0};
        int width = 2;
        System.out.println(findMaxMoles(holes, width));
        System.out.println(findMaxMoles2(holes, width));

    }

    private static int findMaxMoles(int[] arr, int width) {

        int start = 0;
        int end = width - 1;

        int sum = 0, max = 0;

        for (int i = 0; i < width; i++) {
            sum += arr[i];
        }

        max = sum;

        while (end < arr.length - 1) {
            end++;
            sum = sum + arr[end];
            sum = sum - arr[start];
            start++;

            max = Math.max(sum, max);
        }

        return max;
    }

    private static int findMaxMoles2(int[] arr, int width) {

        int start = 0;
        int end = width - 1;

        int otherStart = arr.length - width;
        int otherEnd = arr.length - 1;

        int sum = 0, max = 0, otherSum = 0;

        for (int i = 0; i < width; i++) {
            sum += arr[i];
            otherSum += arr[arr.length - 1 - i];
        }

        max = otherSum + sum;

        while (end < otherStart) {

            if(otherSum > sum){
                end++;
                sum = sum + arr[end];
                sum = sum - arr[start];
                start++;
            }else{
                otherStart--;
                otherSum += arr[otherStart];
                otherSum -= arr[otherEnd];
                otherEnd--;
            }


            max = Math.max(max, otherSum + sum);
        }

        return max;
    }
}
