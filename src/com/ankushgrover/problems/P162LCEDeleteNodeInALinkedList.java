package com.ankushgrover.problems;

import com.ankushgrover.dataStructures.nodes.ListNode;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 02/06/20
 * <p>
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 *
 * #easy #linkedList #O(n) #constant
 */
public class P162LCEDeleteNodeInALinkedList {

    public static void main(String[] args) {



    }

    // O(n)
    public void deleteNode(ListNode node) {
        ListNode next = node.next;

        while(next!=null){
            node.val = next.val;
            next = next.next;
            if(next == null)
                node.next = null;
            node = node.next;
        }
        node = null;
    }

    // #constant
    public void deleteNode1(ListNode node){
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
