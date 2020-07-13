package com.ankushgrover.problems;

import com.ankushgrover.dataStructures.nodes.TreeNode;

import java.util.LinkedList;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 09/07/20
 */
public class P187LCMMinimumWidthOfBinaryTree {

    public static void main(String[] args) {
    }

    public int widthOfBinaryTree(TreeNode root) {

        if (root == null)
            return 0;

        LinkedList<TreeNode> first = new LinkedList<>();

        first.push(root);

        int width = 1;

        LinkedList<TreeNode> stack = new LinkedList<>();

        int end = -1;

        while (!first.isEmpty()) {

            TreeNode node = first.pollFirst();
            TreeNode left = node == null ? null : node.left;
            TreeNode right = node == null ? null : node.right;
            if (stack.isEmpty()) {
                if (node != null) {

                    if (left != null) {
                        stack.push(left);
                        end++;
                    }
                    if (right != null) {
                        stack.push(right);
                        end++;
                    }
                }
            } else {
                stack.push(left);
                stack.push(right);
                if (left != null)
                    end++;
                if (right != null)
                    end++;
            }

            if (first.size() == 0) {
                width = Math.max(width, end);
                if (end != -1) {
                    first.addAll(stack);
                    stack.clear();
                }

            }

        }
        return width;
    }
}
