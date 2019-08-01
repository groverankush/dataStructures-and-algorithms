package com.ankushgrover.problems;

import com.ankushgrover.dataStructures.nodes.ListNode;

public class P27ReverseNodesInGroups {

    public static void main(String[] args) {
        ListNode head = ListNode.create(1, 2, 3, 4, 5);
        ListNode.print(head);
        ListNode.print(reverseKGroup(head, 0));
    }

    private static ListNode reverseKGroup(ListNode node, int k) {
        if (node == null || k < 1)
            return node;
        return reverse(node, 2);
    }

    private static ListNode reverse(ListNode head, int k) {

        ListNode current = head, prev = null, next = null;
        int count = 0;


        while (current != null && count < k) {
            current = current.next;
            count++;
        }

        if (count < k)
            return head;

        current = head;
        count = 0;
        while (current != null && count < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
        if (next != null) {
            head.next = reverse(next, k);
        }

        return prev;

    }
}
