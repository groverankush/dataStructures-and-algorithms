package com.ankushgrover.problems;

import com.ankushgrover.dataStructures.nodes.TreeNode;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 26/08/19
 * <p>
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
public class P56MaxDepthBinaryTree {

    public static void main(String[] args) {

        TreeNode tree = TreeNode.makeTree(1, 2, 3, 4, 5, 6);

        System.out.println(maxDepth(tree));

    }

    private static int maxDepth(TreeNode root) {

        if (root == null)
            return 0;


        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));

    }
}
