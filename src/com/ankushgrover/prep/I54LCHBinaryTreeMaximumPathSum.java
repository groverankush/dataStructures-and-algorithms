package com.ankushgrover.prep;

import com.ankushgrover.dataStructures.nodes.TreeNode;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 16/07/21
 */
public class I54LCHBinaryTreeMaximumPathSum {

    public static void main(String[] args) {


        I54LCHBinaryTreeMaximumPathSum obj = new I54LCHBinaryTreeMaximumPathSum();
        TreeNode root = TreeNode.makeTree(-1, -2, 10, -6, null, -3, -6);
        System.out.println(obj.maxPathSum(root));
    }


    public int maxPathSum(TreeNode root) {
        int[] res = sum(root);
        return max(res, 4);
    }

    private int[] sum(TreeNode cur) {

        if (cur == null)
            return new int[]{0, 0, 0, 0, 0};

        int[] left = sum(cur.left);
        int[] right = sum(cur.right);

        int maxLeft = max(left, 3);
        int maxRight = max(right, 3);

        return new int[]{cur.val, cur.val + maxLeft, cur.val + maxRight, maxEnd(cur.val + maxLeft + maxRight, left, right, cur.val), 1};

    }


    private int max(int[] arr, int limit) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < limit; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    private int maxEnd(int curMax, int[] left, int[] right, int cur) {
        int max = Math.max(curMax, left[4] == 0 ? Integer.MIN_VALUE : left[3]);
        return Math.max(Math.max(max, right[4] == 0 ? Integer.MIN_VALUE : right[3]), cur);
    }
}
