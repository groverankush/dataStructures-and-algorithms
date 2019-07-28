package com.ankushgrover.problems;

import com.ankushgrover.dataStructures.nodes.ListNode;

public class P18RemoveNth {

    public static void main(String[] args) {

        ListNode head = ListNode.create(1, 2, 3, 4, 5, 6, 7);

        ListNode.print(head);

        System.out.println();

        ListNode.print(remove(head, 1));

    }


    private static ListNode remove(ListNode head, int n) {
        ListNode behind = head;
        ListNode ahead = head;
        ListNode prev = null;


        for (int i = 0; i < n; i++) {
            ahead = ahead.next;
        }

        while (ahead != null) {
            ahead = ahead.next;
            prev = behind;
            behind = behind.next;
        }

        if (prev == null)
            head = head.next;
        else
            prev.next = behind.next;

        return head;
    }
}
