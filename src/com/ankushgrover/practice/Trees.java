package com.ankushgrover.practice;

import com.ankushgrover.dataStructures.nodes.NodeT;

import java.util.LinkedList;

public class Trees {

    public static void main(String[] args) {
        NodeT root = makeTree();
        print(root);
        levelOrderTraversal(root);
    }


    private static void levelOrderTraversal(NodeT root) {

        StringBuilder builder = new StringBuilder();
        LinkedList<NodeT> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            NodeT node = q.remove();
            builder.append(node.value);
            builder.append(" ");

            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
        }

        System.out.println(builder);
    }

    private static NodeT makeTree() {
        NodeT root = new NodeT(5);
        root.left = new NodeT(10);
        root.right = new NodeT(15);
        root.left.left = new NodeT(12);
        root.left.right = new NodeT(17);
        root.left.left.left = new NodeT(16);
        root.left.left.right = new NodeT(18);
        root.left.right.left = new NodeT(20);
        root.left.right.right = new NodeT(62);
        return root;
    }

    private static void print(NodeT root) {
        LinkedList<NodeT> printList = new LinkedList<NodeT>();

        printList.add(root);

        StringBuilder builder = new StringBuilder();

        while (!printList.isEmpty()) {
            LinkedList<NodeT> list = new LinkedList<NodeT>();

            while (!printList.isEmpty()) {
                NodeT node = printList.pollFirst();

                if (node == null)
                    continue;

                String left = node.left == null ? "null" : String.valueOf(node.left.value);
                String right = node.right == null ? "null" : String.valueOf(node.right.value);
                builder.append(String.format("%s -> %d <- %s", left, node.value, right));
                builder.append("    ");
                list.add(node.left);
                list.add(node.right);
            }

            builder.append("\n");

            printList.addAll(list);


        }
        System.out.println(builder.toString());
    }

}
