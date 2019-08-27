package com.ankushgrover.problems;

import com.ankushgrover.dataStructures.nodes.ListNode;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 27/08/19
 *
 * https://leetcode.com/problems/palindrome-linked-list/
 */
public class P63PalinfromeLinkedList {

    public static void main(String[] args) {

        ListNode list = ListNode.create(1, 2);

        System.out.println(isPalindrome(list));

    }

    private static boolean isPalindrome(ListNode head) {
        int size = count(head);

        if (size <= 1)
            return true;

        ListNode prev = null, next = head;

        for (int i = 0; i < size / 2; i++) {
            prev = next;
            next = next.next;
        }

        if (size % 2 != 0) {
            next = next.next;
            prev.next = next;
        }

        prev.next = reverse(next);

        prev = head;
        next = head;


        for (int i = 0; i < size / 2; i++) {
            next = next.next;
        }


        while (next != null) {
            if (prev.val != next.val)
                return false;
            prev = prev.next;
            next = next.next;
        }

        return true;


    }


    private static int count(ListNode node) {
        int count = 0;
        while (node != null) {
            node = node.next;
            count++;
        }
        return count;

    }

    private static ListNode reverse(ListNode node) {

        ListNode prev = null, cur = node, next = null;

        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;

    }
}
