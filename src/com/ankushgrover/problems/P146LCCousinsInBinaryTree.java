package com.ankushgrover.problems;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 07/05/20
 */
public class P146LCCousinsInBinaryTree {

    public static void main(String[] args) {
        P146LCCousinsInBinaryTree obj = new P146LCCousinsInBinaryTree();
        //obj.isCousin();
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        int d1 = getDepth(root, x, 0);
        int d2 = getDepth(root, y, 0);
        int p1 = getParent(root, x);
        int p2 = getParent(root, y);

        return d1 == d2 && p1 != p2;


    }

    private int getDepth(TreeNode root, int value, int depth) {

        if (root == null)
            return 0;

        if (root.val == value)
            return depth;

        int localDepth = getDepth(root.left, value, depth + 1);

        if (localDepth != 0)
            return localDepth;

        return getDepth(root.right, value, depth + 1);


    }

    private int getParent(TreeNode root, int value) {
        if(root == null)
            return -1;

        if ((root.left != null && root.left.val == value)
                || (root.right != null && root.right.val == value))
            return root.val;


        int local = getParent(root.left, value);

        if(local!=-1)
            return local;

        return getParent(root.right, value);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
