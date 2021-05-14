package com.ankushgrover.prep;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 13/05/21
 */
public class I26LCMSearchA2DMatrixII {

    public static void main(String[] args) {


        I26LCMSearchA2DMatrixII obj = new I26LCMSearchA2DMatrixII();

        int matrix[][] = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};

        System.out.println(obj.searchMatrix(matrix, 5));

    }

    public boolean searchMatrixBest(int[][] matrix, int target) {

        int r = matrix.length;
        int c = matrix[0].length;

        int row = 0;
        int col = c - 1;

        while (row < r && c >= 0) {

            int element = matrix[row][col];
            if (element == target)
                return true;
            if (element > target) {
                col--;
            } else row++;

        }

        return false;

    }

    public boolean searchMatrix(int[][] matrix, int target) {

        int visited[] = new int[matrix.length];
        return bs2d(matrix, visited, target, 0, matrix.length);

    }

    private boolean bs2d(int arr[][], int visited[], int target, int start, int end) {

        int mid = start + (end - start) / 2;


        if (start > end || visited[mid] == 1)
            return false;

        visited[mid] = 1;

        if (arr[mid][0] == target)
            return true;

        else if (arr[mid][0] > target) {
            return bs2d(arr, visited, target, start, mid - 1);
        } else {

            return bs(arr[mid], target, 0, arr[0].length - 1)
                    || bs2d(arr, visited, target, start, mid - 1)
                    || bs2d(arr, visited, target, mid + 1, end);
        }

    }

    private boolean bs(int[] arr, int target, int start, int end) {

        if (start > end)
            return false;

        int mid = start + (end - start) / 2;
        int element = arr[mid];

        if (element == target)
            return true;
        else if (element < target) {
            return bs(arr, target, mid + 1, end);
        } else {
            return bs(arr, target, start, mid - 1);
        }

    }




    /*while (start < end) {

            int mid = start + (end - start) / 2;

            int element = matrix[mid][0];
            if (element == target)
                return true;

            if (element > target) {
                end = mid - 1;
            } else {
                int lastElement = matrix[mid][cols - 1];

                if (target <= lastElement) {
                    if(bs(matrix[mid], target, 0, cols-1))
                        return true;
                }

                start = mid + 1;

            }
        }

        return false;*/
}
