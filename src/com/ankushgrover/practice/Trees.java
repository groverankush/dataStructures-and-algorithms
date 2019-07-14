package com.ankushgrover.practice;

import com.ankushgrover.dataStructures.nodes.NodeT;

import java.util.LinkedList;
import java.util.Stack;

public class Trees {

    public static void main(String[] args) {
        NodeT root = makeTree();
        print(root);
        zigZagTraversal(root);

    }

    private static void zigZagTraversal(NodeT root){

        Stack<NodeT> left = new Stack<>();
        Stack<NodeT> right = new Stack<>();

        left.add(root);

        boolean isLeft = true;

        StringBuilder builder = new StringBuilder();
        while(!left.isEmpty() || !right.isEmpty()){


            Stack<NodeT> stack = isLeft ? left : right;

            NodeT node = stack.pop();
            if(isLeft){
                if(node.left!=null)
                    right.push(node.left);
                if(node.right!=null)
                    right.push(node.right);
            }

            else{
                if(node.right!=null)
                    left.push(node.right);
                if(node.left!=null)
                    left.push(node.left);
            }

            builder.append(node.value);
            builder.append(" ");

            isLeft = stack.isEmpty() != isLeft;

        }

        System.out.println(builder.toString());
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
