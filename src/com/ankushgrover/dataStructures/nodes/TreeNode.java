package com.ankushgrover.dataStructures.nodes;

import java.util.LinkedList;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    /*public static TreeNode makeTree(int... nodes) {

        if (nodes.length == 0)
            return null;

        TreeNode root = new TreeNode(nodes[0]);

        LinkedList<TreeNode> list = new LinkedList<>();

        list.add(root);

        int index = 1;

        while (index < nodes.length) {

            TreeNode node = list.pop();
            node.left = new TreeNode(nodes[index]);
            list.addLast(node.left);

            index++;

            node.right = index < nodes.length ? new TreeNode(nodes[index]) : null;
            list.addLast(node.right);

            index++;

        }

        return root;

    }*/

    public static TreeNode makeTree(Integer... nodes) {

        TreeNode root = new TreeNode(nodes[0]);
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();

        q.add(root);

        int i = 1;
        while (!q.isEmpty() && i < nodes.length) {

            TreeNode node = q.poll();

            TreeNode left = nodes[i] == null ? null : new TreeNode(nodes[i]);
            i++;
            TreeNode right = nodes[i] == null ? null : new TreeNode(nodes[i]);
            i++;


            node.left = left;
            node.right = right;


            if (left != null)
                q.add(left);
            if (right != null)
                q.add(right);


        }


        return root;
    }


    public static String toString(TreeNode node) {

        LinkedList<TreeNode> list = new LinkedList<>();

        list.add(node);

        StringBuilder builder = new StringBuilder();

        while (!list.isEmpty()) {

            TreeNode temp = list.pop();
            if (temp == null)
                builder.append("null");
            else {
                builder.append(temp.val);
                list.addLast(temp.left);
                list.addLast(temp.right);
            }


            builder.append(",");

        }

        builder.replace(builder.length() - 1, builder.length(), "");

        return builder.toString();


    }

    @Override
    public String toString() {
        return "TreeNode: " + val;
    }
}
