package com.ankushgrover.problems;

import com.ankushgrover.dataStructures.nodes.ListNode;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 */
public class P24SwapNodesInPairs {

    public static void main(String[] args) {

        ListNode node = ListNode.create(1, 2, 3, 4, 5, 6, 7);
        ListNode.print(node);

        ListNode.print(reverse(node, 2));

        //ListNode.print(swapPairs01(node));


    }

    private static ListNode reverse(ListNode head, int k) {
        ListNode current = head, prev = null, next = null;

        int count = 0;

        while (current != null && count < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        if (next != null)
            head.next = reverse(next, k);

        return prev;
    }
}
