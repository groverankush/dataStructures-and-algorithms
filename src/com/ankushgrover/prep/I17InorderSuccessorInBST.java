package com.ankushgrover.prep;

import com.ankushgrover.dataStructures.nodes.TreeNode;

import java.util.List;
import java.util.Stack;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 08/05/21
 * <p>
 * https://www.lintcode.com/problem/inorder-successor-in-bst/
 * https://leetcode.com/problems/inorder-successor-in-bst/
 */
public class I17InorderSuccessorInBST {

    public static void main(String[] args) {


    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        /*List<TreeNode> list = new ArrayList<>();

        recursive(root, list);

        for(int i = 0 ; i < list.size()-1;i++){
            if(list.get(i) == p){
                return list.get(i+1);
            }
        }
        return null;*/

        return iterative(root, p);
    }

    private TreeNode iterative(TreeNode root, TreeNode node) {
        if (root == null || node == null)
            return null;

        Stack<TreeNode> stack = new Stack<>();
        boolean considerNext = false;
        while (!(considerNext && root == null && stack.isEmpty())) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (considerNext) {
                return stack.pop();
            }
            root = stack.pop();
            if (root == node) {
                considerNext = true;
            }
            root = root.right;
        }

        return null;
    }

    private void recursive(TreeNode root, List<TreeNode> list) {

        if (root == null) {
            return;
        }

        recursive(root.left, list);
        list.add(root);
        recursive(root.right, list);
    }
}
