package com.ankushgrover.prep;

import com.ankushgrover.dataStructures.nodes.TreeNode;

import java.util.*;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 15/06/21
 */
public class I40LCHVerticalOrderTraversalOfBinaryTree {

    public static void main(String[] args) {
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, PriorityQueue<Node>> map = new TreeMap<>();
        inorder(root, 0, 0, map);

        List<List<Integer>> res = new ArrayList<>();

        for (Map.Entry<Integer, PriorityQueue<Node>> entry : map.entrySet()) {

            List<Integer> list = new ArrayList<>();

            PriorityQueue<Node> q = entry.getValue();

            while(!q.isEmpty()){
                list.add(q.poll().val);
            }
            res.add(list);

        }

        return res;
    }

    private void inorder(TreeNode node, int x, int y, TreeMap<Integer, PriorityQueue<Node>> map) {

        if (node == null)
            return;

        inorder(node.left, x + 1, y - 1, map);

        Node n = new Node(node.val, x);
        PriorityQueue<Node> q = map.get(y);

        if (q == null) {
            q = new PriorityQueue<>();
            map.put(y, q);
        }

        q.add(n);


        inorder(node.left, x + 1, y - 1, map);

    }

    class Node implements Comparable<Node> {
        int val;
        int x;


        Node(int val, int x) {

            this.val = val;
            this.x = x;


        }

        @Override
        public int compareTo(Node node) {
            if (this.x == node.x)
                return this.val - node.val;
            return this.x - node.x;
        }
    }
}
