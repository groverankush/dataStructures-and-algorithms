package com.ankushgrover.problems;

import com.ankushgrover.dataStructures.nodes.TreeNode;

import java.util.ArrayList;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 29/08/19
 */
public class P66ConvertBSTToGreaterTree {

    public static void main(String[] args) {

        TreeNode tree = TreeNode.makeTree(5,2,13,3,2,6,15);

        System.out.println(TreeNode.toString(convertBST(tree)));

    }

    private static TreeNode convertBST(TreeNode root) {

        ArrayList<TreeNode> list = new ArrayList<>();

        traverse(root, list);

        for(int i = list.size()-2; i >= 0; i--){
            list.get(i).val = list.get(i).val + list.get(i+1).val;
        }

        return root;


    }

    private static void traverse(TreeNode node, ArrayList<TreeNode> list){

        if(node == null)
            return;

        traverse(node.left, list);

        list.add(node);

        traverse(node.right, list);

    }
}
