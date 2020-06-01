package com.ankushgrover.interview;

import com.ankushgrover.dataStructures.nodes.TreeNode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/invert-binary-tree/
 * <p>
 * #easy #dfs #bfs
 */
public class P45InvertBinaryTree {

    public static void main(String[] args) {
        TreeNode root = TreeNode.makeTree(1, 2, 3, 4, 5, 6);
        System.out.println(TreeNode.toString(root));
        root = invertTree(root);

        System.out.println(TreeNode.toString(root));
    }

    // DFS
    private static TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    private static void invert(TreeNode node) {

        if (node == null)
            return;

        invert(node.left);
        invert(node.right);


        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

    }

    //BFS
    public TreeNode invertTreeBFS(TreeNode root) {

        if (root == null)
            return null;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode parent = stack.pop();
            TreeNode temp = parent.left;
            parent.left = parent.right;
            parent.right = temp;
            if (parent.left != null)
                stack.push(parent.left);
            if (parent.right != null)
                stack.push(parent.right);
        }
        return root;

    }
}
