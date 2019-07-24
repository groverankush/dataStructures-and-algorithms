package com.ankushgrover.problems;

/**
 * https://leetcode.com/problems/container-with-most-water/
 */
public class P12ContainerWithMostWater {

    public static void main(String[] args) {
        //{2, 3, 10, 5, 7, 8, 9};
        int[] arr = {2, 3, 10, 5, 7, 8, 9};
        System.out.println(maxArea(arr));
    }


    private static int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int max = 0;
        while (start < end) {
            max = Math.max(max, Math.min(height[start], height[end]) * (end - start));

            if (height[end] < height[start])
                end--;
            else start++;
        }
        return max;
    }
}
