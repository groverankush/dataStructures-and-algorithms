package com.ankushgrover.problems;

import com.ankushgrover.dataStructures.nodes.TreeNode;

public class P45InvertBinaryTree {

    public static void main(String[] args) {
        TreeNode root = TreeNode.makeTree(1,2,3,4,5,6);
        System.out.println(TreeNode.toString(root));
        root = invertTree(root);

        System.out.println(TreeNode.toString(root));
    }

    private static TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    private static void invert(TreeNode node){

        if(node == null)
            return;

        invert(node.left);
        invert(node.right);


        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

    }
}
