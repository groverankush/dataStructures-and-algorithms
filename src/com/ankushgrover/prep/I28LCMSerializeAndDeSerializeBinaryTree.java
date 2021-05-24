package com.ankushgrover.prep;

import com.ankushgrover.dataStructures.nodes.TreeNode;

import java.util.LinkedList;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 22/05/21
 */
public class I28LCMSerializeAndDeSerializeBinaryTree {

    public static void main(String[] args) {


        I28LCMSerializeAndDeSerializeBinaryTree ser = new I28LCMSerializeAndDeSerializeBinaryTree();
        I28LCMSerializeAndDeSerializeBinaryTree deser = new I28LCMSerializeAndDeSerializeBinaryTree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = null;
        root.left.right = null;

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        TreeNode ans = deser.deserialize(ser.serialize(root));

    }

    public String serialize(TreeNode root) {

        if (root == null)
            return null;

        LinkedList<TreeNode> list = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        int count = 1;

        list.add(root);

        while (count > 0) {

            TreeNode node = list.pollFirst();

            if (node == null) {
                builder.append("null,");
            } else {
                count--;
                builder.append(node.val);

                if (node.left != null) {
                    count++;
                }
                if (node.right != null)
                    count++;

                list.add(node.left);
                list.add(node.right);
            }
        }

        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if (data == null)
            return null;

        String[] arr = data.split(",");

        LinkedList<TreeNode> list = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));

        list.add(root);

        int index = 1;
        while (!list.isEmpty()) {

            TreeNode node = list.pollFirst();

            String l = arr[index++];
            String r = arr[index++];

            node.left = parseTreeNode(l);
            node.right = parseTreeNode(r);

            if (node.left != null)
                list.add(node.left);
            if (node.right != null)
                list.add(node.right);

        }

        return root;

    }

    private TreeNode parseTreeNode(String s) {
        if (s.equals("null"))
            return null;

        return new TreeNode(Integer.parseInt(s));
    }

    // Encodes a tree to a single string.
    /*public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        inorder(root, builder);
        builder.append("-");
        preorder(root, builder);

        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {



        String parts[] =  data.split("-");
        System.out.println("Parts size: " + parts);
        if(parts.length != 2){
            return null;
        }


        String inorder [] = parts[0].split(",");
        String preorder [] = parts[1].split(",");

        System.out.println("Inorder: " + Arrays.toString(inorder));
        System.out.println("Preorder: " + Arrays.toString(preorder));


        HashMap<Integer, Integer> inorderMap = new HashMap<>();

        for(int i = 0; i < inorder.length; i++){

            inorderMap.put(Integer.parseInt(inorder[i]), i );

        }
        return makeTree(preorder, 0, inorderMap, 0, inorder.length-1);


    }

    private TreeNode makeTree(String [] preorder, int rootIndex, HashMap<Integer, Integer> inorderMap, int start, int end){

        if(start > end || rootIndex >= preorder.length)
            return null;

        TreeNode node = new TreeNode(Integer.parseInt(preorder[rootIndex]));

        int inorderNodeIndex = inorderMap.get(node.val);
        node.left = makeTree(preorder,rootIndex+1,inorderMap, start, inorderNodeIndex-1);
        node.right = makeTree(preorder, rootIndex + inorderNodeIndex - start + 1, inorderMap, inorderNodeIndex + 1, end);

        return node;

    }

    private void inorder(TreeNode node, StringBuilder builder){
        if(node == null)
            return;

        inorder(node.left, builder);
        builder.append(node.val);
        builder.append(",");
        inorder(node.right, builder);
    }

    private void preorder(TreeNode node, StringBuilder builder){
        if(node == null)
            return;

        builder.append(node.val);
        builder.append(",");
        preorder(node.left, builder);
        preorder(node.right, builder);
    }*/
}
