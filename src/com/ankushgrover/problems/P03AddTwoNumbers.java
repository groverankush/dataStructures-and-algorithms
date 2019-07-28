package com.ankushgrover.problems;

import com.ankushgrover.dataStructures.nodes.ListNode;

/**
 * https://leetcode.com/problems/add-two-numbers/
 */
public class P03AddTwoNumbers {

    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = l1;
        ListNode prev = l1;
        int carry = 0;


        while (!(l1 == null && l2 == null)) {
            if (l1 == null) {
                l1 = new ListNode(0);
                prev.next = l1;
            }
            int first = l1.val;
            int sec = l2 == null ? 0 : l2.val;

            int sum = first + sec + carry;
            carry = sum >= 10 ? 1 : 0;
            l1.val = sum % 10;

            prev = l1;
            l1 = l1.next;
            l2 = l2.next;

        }

        if (carry == 1) {
            ListNode node = new ListNode(1);
            prev.next = node;
        }

        return result;
    }
}
