package com.ankushgrover.problems;

import com.ankushgrover.dataStructures.nodes.TreeNode;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 25/08/19
 * <p>
 * https://leetcode.com/problems/symmetric-tree/
 */
public class P55IsSymmetric {

    public static void main(String[] args) {

        TreeNode tree = TreeNode.makeTree(1, 2, 2, 3, 4, 4, 3);

        System.out.println(isSymmetric(tree));

    }

    private static boolean isSymmetric(TreeNode root) {

        if (root == null)
            return true;

        return isSymmetric(root.left, root.right);
    }

    private static boolean isSymmetric(TreeNode left, TreeNode right) {

        if (left == null && right == null)
            return true;

        if (left == null || right == null)
            return false;

        return (left.val == right.val
                && isSymmetric(left.left, right.right)
                && isSymmetric(left.right, right.left));

    }
}
