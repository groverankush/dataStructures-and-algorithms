package com.ankushgrover.problems;

import com.ankushgrover.dataStructures.nodes.TreeNode;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 30/08/19
 * <p>
 * https://leetcode.com/problems/diameter-of-binary-tree/
 */
public class P67BinaryTreeDiameter {

    private static int max = 0;

    public static void main(String[] args) {

        TreeNode tree = TreeNode.makeTree(1,2,3,4,5,6,7,8);

        System.out.println(diameterOfBinaryTree(tree));

    }



    private static int diameterOfBinaryTree(TreeNode root) {

        height(root);
        return max;

    }

    private static int height(TreeNode node) {

        if (node == null)
            return 0;

        int left = height(node.left);
        int right = height(node.right);

        max = Math.max(max, left + right);

        return Math.max(left, right) + 1;


    }
}
