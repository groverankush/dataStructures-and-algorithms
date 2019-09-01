package com.ankushgrover.problems;

import com.ankushgrover.dataStructures.nodes.TreeNode;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 01/09/19
 */
public class P70MergeTwoBinaryTrees {

    public static void main(String[] args) {
    }


    private static TreeNode mergeTreesV2(TreeNode t1, TreeNode t2) {

        if(t1 == null)
            return t1;

        if(t2 == null )
            return t2;

        t1.val  = t1.val + t2.val;

        t1.left = mergeTreesV2(t1.left, t2.left);
        t1.right = mergeTreesV2(t1.right, t2.right);

        return t1;

    }

    private static TreeNode mergeTreesV1(TreeNode t1, TreeNode t2) {


        if (t1 == null)
            return t2;

        if (t2 == null)
            return t1;

        merge(t1, t2);

        return t1;

    }

    private static void merge(TreeNode t1, TreeNode t2) {

        if (t1 == null || t2 == null)
            return;


        merge(t1.left, t2.left);

        t1.val = t1.val + t2.val;


        if (t1.left == null) {
            t1.left = t2.left;
        }

        merge(t1.right, t2.right);

        if (t1.right == null) {
            t1.right = t2.right;
        }

    }
}
