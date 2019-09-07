package com.ankushgrover.problems;

import com.ankushgrover.dataStructures.nodes.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 07/09/19
 */
public class P84IterativeInrrderTraversal {

    public static void main(String[] args) {

        TreeNode tree = TreeNode.makeTree(1, 2, 3, 4);

        System.out.println(inorderTraversal(tree));

    }


    public static List<Integer> inorderTraversal(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();

        TreeNode curr = root;


        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }

        return result;

    }
}
