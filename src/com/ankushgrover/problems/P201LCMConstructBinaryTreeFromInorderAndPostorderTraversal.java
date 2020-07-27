package com.ankushgrover.problems;

import com.ankushgrover.dataStructures.nodes.TreeNode;

import java.util.HashMap;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 27/07/20
 * <p>
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * <p>
 * #medium
 */
public class P201LCMConstructBinaryTreeFromInorderAndPostorderTraversal {

    public static void main(String[] args) {

        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        P201LCMConstructBinaryTreeFromInorderAndPostorderTraversal obj = new P201LCMConstructBinaryTreeFromInorderAndPostorderTraversal();
        TreeNode.toString(obj.buildTree(inorder, postorder));


    }


    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0 || inorder.length == 0)
            return null;

        HashMap<Integer, Integer> inMap = new HashMap<>();
        HashMap<Integer, Integer> postMap = new HashMap<>();

        fillMap(inorder, inMap);
        fillMap(postorder, postMap);

        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        int start = 0, end = inMap.get(postorder[postorder.length - 1]);
        int index = getIndexOfFirstOccurringElementInPostOrderFromInOrder(start, end, inorder, inMap, postorder, postMap);
        root.left = findChild(0, index - 1, inorder, inMap, postorder, postMap);
        root.right = findChild(index + 1, postorder.length - 1, inorder, inMap, postorder, postMap);


        return root;
    }

    private TreeNode findChild(int start, int end, int[] inorder, HashMap<Integer, Integer> inMap, int[] postorder, HashMap<Integer, Integer> postMap) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(inorder[start]);
        }

        int index = getIndexOfFirstOccurringElementInPostOrderFromInOrder(start, end, inorder, inMap, postorder, postMap);

        TreeNode node = new TreeNode(inorder[index]);
        node.left = findChild(start, index - 1, inorder, inMap, postorder, postMap);
        node.right = findChild(index + 1, end, inorder, inMap, postorder, postMap);

        return node;
    }

    private void fillMap(int[] arr, HashMap<Integer, Integer> map) {

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

    }


    private int getIndexOfFirstOccurringElementInPostOrderFromInOrder(int start, int end, int[] inorder, HashMap<Integer, Integer> inMap, int[] postorder, HashMap<Integer, Integer> postMap) {
        for (int i = postorder.length - 1; i >= 0; i--) {

            int index = inMap.get(postorder[i]);
            if (index >= start && index <= end) {
                return index;
            }

        }

        return -1;
    }
}
