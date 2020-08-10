package com.ankushgrover.problems;

import com.ankushgrover.dataStructures.nodes.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 07/08/20
 * <p>
 * https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
 * <p>
 * #medium
 */
public class P206LCMVerticalOrderTraversalOfABinaryTree {

    public static void main(String[] args) {
    }

    //[0,5,1,9,null,2,null,null,null,null,3,4,8,6,null,null,null,7]

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        TreeMap<Integer, TreeSet<Node>> map = new TreeMap<>();

        orderHelper(map, root, 0, 0);

        List<List<Integer>> result = new ArrayList<>();

        for (Integer key : map.keySet()) {

            TreeSet<Node> set = map.get(key);
            List<Integer> list = new ArrayList<>();

            for (Node node : set) {
                list.add(node.val);
            }

            result.add(list);

        }

        return result;
    }


    private void orderHelper(TreeMap<Integer, TreeSet<Node>> map, TreeNode node, int x, int y) {

        if (node == null)
            return;

        orderHelper(map, node.left, x - 1, y + 1);

        TreeSet<Node> reference = map.getOrDefault(x, null);
        if (reference == null) {
            reference = new TreeSet<>();
            map.put(x, reference);
        }
        Node temp = new Node(x, y, node.val);
        reference.add(temp);

        orderHelper(map, node.right, x + 1, y + 1);


    }

    class Node implements Comparable<Node> {

        int x;
        int y;
        int val;

        public Node(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Node o) {
            if (o.x == x && o.y == y) {
                return o.val - val;
            }
            return o.y - y;
        }
    }
}
