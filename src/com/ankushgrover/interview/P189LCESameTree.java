package com.ankushgrover.interview;

import com.ankushgrover.dataStructures.nodes.TreeNode;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 13/07/20
 * <p>
 * https://leetcode.com/problems/same-tree/
 * <p>
 * #easy #tree
 */
public class P189LCESameTree {

    public static void main(String[] args) {
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null)
            return true;
        if (p != null && q != null && p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;

    }
}
