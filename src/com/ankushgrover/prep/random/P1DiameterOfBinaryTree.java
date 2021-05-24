package com.ankushgrover.prep.random;

import com.ankushgrover.dataStructures.nodes.TreeNode;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 22/05/21
 */
public class P1DiameterOfBinaryTree {

    public static void main(String[] args) {
        P1DiameterOfBinaryTree obj = new P1DiameterOfBinaryTree();

        TreeNode root = TreeNode.makeTree(1, 2, 3, 4);

        int diameter = obj.diameter(root, 0);
        System.out.println("Diameter: " + diameter);


    }

    private int diameter(TreeNode node, int max) {

        if (node == null)
            return 0;

        int leftLength = diameter(node.left, max + 1);
        int rightLength = diameter(node.right, max + 1);
        int total = 1 + leftLength + rightLength;

        max = Math.max(max, total);

        return max;

    }
}
