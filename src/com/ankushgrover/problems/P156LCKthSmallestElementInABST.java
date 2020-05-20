package com.ankushgrover.problems;

import com.ankushgrover.dataStructures.nodes.TreeNode;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 20/05/20
 * <p>
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 */
public class P156LCKthSmallestElementInABST {

    int index = 0;

    public static void main(String[] args) {
    }

    public int kthSmallest(TreeNode root, int k) {

        if (root == null) {
            return -1;
        }


        int value = kthSmallest(root.left, k);

        if (value != -1)
            return value;

        index++;
        if (index == k)
            return root.val;

        return kthSmallest(root.right, k);


    }
}
