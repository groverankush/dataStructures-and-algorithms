package com.ankushgrover.problems;

import com.ankushgrover.dataStructures.nodes.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 22/07/20
 * <p>
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * <p>
 * #medium
 */
public class P197LCMBinaryTreeZigzagLevelOrderTraversal {

    public static void main(String[] args) {
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if (root == null)
            return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Stack<TreeNode> first = new Stack<>();
        Stack<TreeNode> second = new Stack<>();

        second.add(root);

        boolean leftToRight = false;

        while (first.size() > 0 || second.size() > 0) {

            Stack<TreeNode> stack = leftToRight ? first : second;
            Stack<TreeNode> toPut = leftToRight ? second : first;

            TreeNode node = stack.pop();
            if (leftToRight) {
                if (node.right != null)
                    toPut.add(node.right);
                if (node.left != null)
                    toPut.add(node.left);
            } else {
                if (node.left != null)
                    toPut.add(node.left);
                if (node.right != null)
                    toPut.add(node.right);
            }
            temp.add(node.val);

            if (stack.isEmpty()) {
                res.add(temp);
                temp = new ArrayList<>();
                leftToRight = !leftToRight;
            }
        }

        return res;

    }
}
