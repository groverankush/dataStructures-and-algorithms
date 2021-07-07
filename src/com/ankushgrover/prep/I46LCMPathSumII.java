package com.ankushgrover.prep;

import com.ankushgrover.dataStructures.nodes.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 30/06/21
 */
public class I46LCMPathSumII {

    public static void main(String[] args) {
        I46LCMPathSumII obj = new I46LCMPathSumII();

        //Integer [] arr = new Integer[] {5,4,8,11,null,13,4,7,2,null,null,5,1};
        TreeNode root = TreeNode.makeTree(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1);
        int targetSum = 22;


        System.out.println(obj.pathSum(root, targetSum));
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        return calculate(root, 0, targetSum, new ArrayDeque<Integer>());
    }

    private List<List<Integer>> calculate(TreeNode node, int sum, int targetSum, ArrayDeque<Integer> path) {

        if (node == null)
            return new ArrayList<>();

        path.add(node.val);
        sum = sum + node.val;

        List<List<Integer>> ll = calculate(node.left, sum, targetSum, path);
        List<List<Integer>> rl = calculate(node.right, sum, targetSum, path);

        List<List<Integer>> res = new ArrayList<>();

        if (sum == targetSum)
            res.add(new ArrayList<>(path));

        if (ll != null)
            res.addAll(ll);

        if (rl != null)
            res.addAll(rl);

        path.removeLast();

        return res;
    }
}
