package com.ankushgrover.problems;

public class P18RemoveNth {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        print(head);
        System.out.println();
        print(remove(head, 1));

    }

    private static void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
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

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
