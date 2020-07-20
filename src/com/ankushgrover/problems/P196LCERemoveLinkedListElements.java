package com.ankushgrover.problems;

import com.ankushgrover.dataStructures.nodes.ListNode;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 20/07/20
 * <p>
 * https://leetcode.com/problems/remove-linked-list-elements/
 * <p>
 * #easy #linkedList
 */
public class P196LCERemoveLinkedListElements {

    public static void main(String[] args) {
    }

    public ListNode removeElements(ListNode head, int val) {

        ListNode cur = head;
        ListNode end = null;
        ListNode start = null;


        while (cur != null) {
            if (cur.val != val) {
                if (start == null) {
                    start = cur;
                    end = start;
                } else {
                    end.next = cur;
                    end = end.next;
                }
            }
            cur = cur.next;
        }

        if (end != null)
            end.next = null;

        return start;
    }
}
