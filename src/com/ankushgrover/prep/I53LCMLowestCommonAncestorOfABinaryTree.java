package com.ankushgrover.prep;

import com.ankushgrover.dataStructures.nodes.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 16/07/21
 */
public class I53LCMLowestCommonAncestorOfABinaryTree {

    public static void main(String[] args) {


        I53LCMLowestCommonAncestorOfABinaryTree obj = new I53LCMLowestCommonAncestorOfABinaryTree();
        TreeNode root = TreeNode.makeTree(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);
        TreeNode p = root.left.left;
        TreeNode q = root.left.right;
        obj.lowestCommonAncestor(root, p, q);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return method(root, p, q);
    }

    private TreeNode method(TreeNode root, TreeNode p, TreeNode q) {

        HashSet<TreeNode> set = new HashSet<>();
        findP(root, p, set);
        List<TreeNode> res = new ArrayList<>();
        findQ(root, q, set, res);
        return res.get(0);

    }

    private boolean findQ(TreeNode root, TreeNode node, HashSet<TreeNode> set, List<TreeNode> res) {

        if (root == null)
            return false;

        if (root == node) {
            if (set.contains(root))
                res.add(root);

            return true;
        }

        boolean inLeft = findQ(root.left, node, set, res);
        if (inLeft) {
            if (res.isEmpty() && set.contains(root))
                res.add(root);
            return true;
        }

        boolean inRight = findQ(root.right, node, set, res);

        if (inRight) {
            if (res.isEmpty() && set.contains(root))
                res.add(root);
            return true;
        }

        return false;

    }

    private boolean findP(TreeNode root, TreeNode node, HashSet<TreeNode> set) {

        if (root == null)
            return false;

        if (root == node) {
            set.add(root);
            return true;
        }

        boolean inLeft = findP(root.left, node, set);
        if (inLeft) {
            set.add(root);
            return true;
        }

        boolean inRight = findP(root.right, node, set);

        if (inRight) {
            set.add(root);
        }

        return inRight;

    }
}
