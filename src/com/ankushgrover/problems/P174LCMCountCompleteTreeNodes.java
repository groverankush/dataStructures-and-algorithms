package com.ankushgrover.problems;

import com.ankushgrover.dataStructures.nodes.TreeNode;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 23/06/20
 * <p>
 * https://leetcode.com/problems/count-complete-tree-nodes/
 * <p>
 * #medium #tree #completeBinaryTree #dfs
 */
public class P174LCMCountCompleteTreeNodes {

    public static void main(String[] args) {
    }

    public int countNodes(TreeNode root) {
        return countNode(root, 0);
    }

    public int countNode(TreeNode root, int c) {
        if (root == null)
            return 0;

        return 1 + countNode(root.left, c + 1) + countNode(root.right, c + 1);


    }
}
