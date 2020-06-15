package com.ankushgrover.problems;

import com.ankushgrover.dataStructures.nodes.TreeNode;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 15/06/20
 * <p>
 * https://leetcode.com/problems/search-in-a-binary-search-tree/
 * <p>
 * #easy #binarySearchTree #bst #search
 */
public class P171LCESearchInABinarySearchTree {

    public static void main(String[] args) {
    }

    public TreeNode searchBST(TreeNode root, int val) {

        while (root != null) {
            if (root.val == val)
                return root;
            if (root.val > val) {
                root = root.left;
            } else root = root.right;
        }

        return null;

    }


}
