package com.ankushgrover.prep;

import com.ankushgrover.dataStructures.nodes.TreeNode;

import java.util.HashMap;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 06/05/21
 */
public class I16ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public static void main(String[] args) {
        I16ConstructBinaryTreeFromPreorderAndInorderTraversal obj = new I16ConstructBinaryTreeFromPreorderAndInorderTraversal();

        int preorder[] = {1, 2, 3};
        int inorder[] = {3, 2, 1};
        obj.buildTree(preorder, inorder);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < preorder.length; i++) {

            map.put(preorder[i], i);

        }

        return makeTree(inorder, map, 0, preorder.length);

    }

    private TreeNode makeTree(int inOrder[], HashMap<Integer, Integer> preOrderMap, int start, int end) {

        if (start > end || start >= inOrder.length || end > inOrder.length) {
            return null;
        }

        if (start == end) {
            return new TreeNode(inOrder[start]);
        }

        int min = Integer.MAX_VALUE;
        int inOrderIndex = -1;
        for (int i = start; i < end; i++) {

            int index = preOrderMap.get(inOrder[i]);

            if (index < min) {
                min = index;
                inOrderIndex = i;
            }

        }

        TreeNode node = new TreeNode(inOrder[inOrderIndex]);

        node.left = makeTree(inOrder, preOrderMap, start, inOrderIndex);
        node.right = makeTree(inOrder, preOrderMap, inOrderIndex + 1, end);

        return node;

    }
}
