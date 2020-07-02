package com.ankushgrover.problems;

import com.ankushgrover.dataStructures.nodes.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 02/07/20
 * <p>
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 * <p>
 * #easy #bfs
 */
public class P179LCEBinaryLevelOrderTraversalII {

    public static void main(String[] args) {
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        LinkedList<List<Integer>> result = new LinkedList<>();


        ArrayList<TreeNode> first = new ArrayList<>();
        ArrayList<TreeNode> second = new ArrayList<>();
        first.add(root);


        while (first.size() > 0) {

            ArrayList<Integer> temp = new ArrayList<>();
            for (TreeNode node : first) {
                if (node == null)
                    continue;
                temp.add(node.val);
                second.add(node.left);
                second.add(node.right);
            }
            if (temp.size() > 0)
                result.addFirst(temp);
            first = second;
            second = new ArrayList<>();

        }

        return result;

    }
}
