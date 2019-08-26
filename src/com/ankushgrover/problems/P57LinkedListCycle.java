package com.ankushgrover.problems;

import com.ankushgrover.dataStructures.nodes.ListNode;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 26/08/19
 * <p>
 * https://leetcode.com/problems/linked-list-cycle/
 */
public class P57LinkedListCycle {

    public static void main(String[] args) {

        // Since no method is written to make a cyclic list, leaving it blank.
    }

    public boolean hasCycle(ListNode head) {

        if (head == null)
            return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != null && fast != null) {

            if (slow == fast)
                return true;

            fast = fast.next;
            if (fast == null)
                return false;
            else fast = fast.next;
            slow = slow.next;

        }

        return false;

    }
}
