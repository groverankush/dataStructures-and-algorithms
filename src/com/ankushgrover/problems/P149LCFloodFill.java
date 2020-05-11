package com.ankushgrover.problems;

import java.util.Arrays;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 11/05/20
 * <p>
 * An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).
 * <p>
 * Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.
 * <p>
 * To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.
 * <p>
 * At the end, return the modified image.
 * <p>
 * Example 1:
 * Input:
 * image = [[1,1,1],[1,1,0],[1,0,1]]
 * sr = 1, sc = 1, newColor = 2
 * Output: [[2,2,2],[2,2,0],[2,0,1]]
 * Explanation:
 * From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected
 * by a path of the same color as the starting pixel are colored with the new color.
 * Note the bottom corner is not colored 2, because it is not 4-directionally connected
 * to the starting pixel.
 * Note:
 * <p>
 * The length of image and image[0] will be in the range [1, 50].
 * The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < image[0].length.
 * The value of each color in image[i][j] and newColor will be an integer in [0, 65535].
 */
public class P149LCFloodFill {

    public static void main(String[] args) {
        P149LCFloodFill obj = new P149LCFloodFill();
        int image[][] = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        obj.print(image);
        image = obj.floodFill(image, 1, 1, 2);

        obj.print(image);
    }

    private void print(int image[][]) {
        for (int i = 0; i < image.length; i++) {
            System.out.println(Arrays.toString(image[i]));
        }
        System.out.println("\n\n");
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        boolean[][] visited = new boolean[image.length][image[0].length];

        dfs(image, visited, image[sr][sc], newColor, sr, sc);
        return image;

    }


    private void dfs(int[][] image, boolean[][] visited, int color, int newColor, int sr, int sc) {

        if (sr >= image.length || sr < 0 || sc >= image[0].length || sc < 0 || visited[sr][sc] || image[sr][sc] != color)
            return;

        image[sr][sc] = newColor;


        int[] srs = {-1, 0, 1, 0};
        int[] scs = {0, -1, 0, 1};

        for (int i = 0; i < 4; i++) {
            dfs(image, visited, color, newColor, sr + srs[i], sc + scs[i]);
            visited[sr][sc] = true;
        }

    }
}
