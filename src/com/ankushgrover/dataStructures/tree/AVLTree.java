package com.ankushgrover.dataStructures.tree;

import com.ankushgrover.dataStructures.nodes.NodeT;

import java.util.LinkedList;

/**
 * AVL Tree representation
 */
public class AVLTree {

    private NodeT root;

    public void insert(int item) {
        root = insert(root, item);
    }

    private NodeT insert(NodeT node, int item) {
        if (node == null) {
            return new NodeT(item);
        }

        if (item < node.value) {
            node.left = insert(node.left, item);
        } else if (item > node.value) {
            node.right = insert(node.right, item);
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int bf = balancingFactor(node);

        // LL Case
        if (bf > 1 && item < node.left.value) {
            return rightRotate(node);
        }

        // RR Case
        if (bf < -1 && item > node.right.value) {
            return leftRotate(node);
        }

        // LR case
        if (bf > 1 && item > node.left.value) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (bf < -1 && item < node.right.value) {
            node.right = rightRotate(node.right);
            return leftRotate(node.left);
        }

        return node;

    }

    private NodeT rightRotate(NodeT node) {

        NodeT result = node.left;
        NodeT right = result.right;

        result.right = node;
        node.left = right;

        node.height = 1 + Math.max(height(node.left), height(node.right));
        result.height = 1 + Math.max(height(result.left), height(result.right));

        return result;
    }

    private NodeT leftRotate(NodeT node) {

        NodeT result = node.right;
        NodeT left = result.left;

        result.left = node;
        node.right = left;

        node.height = 1 + Math.max(height(node.left), height(node.right));
        result.height = 1 + Math.max(height(result.left), height(result.right));

        return result;
    }

    private int height(NodeT node) {
        if (node == null)
            return 0;

        return node.height;

    }

    private int balancingFactor(NodeT node) {


        return height(node.left) - height(node.right);

    }


    public String toString() {

        LinkedList<NodeT> printList = new LinkedList<NodeT>();

        printList.add(root);

        StringBuilder builder = new StringBuilder();

        while (!printList.isEmpty()) {
            LinkedList<NodeT> list = new LinkedList<NodeT>();

            while (!printList.isEmpty()) {
                NodeT node = printList.pollFirst();

                if(node == null)
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
        return builder.toString();
    }


}