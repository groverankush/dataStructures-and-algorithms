package com.ankushgrover.problems;

import com.ankushgrover.dataStructures.nodes.ListNode;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 27/08/19
 *
 * https://leetcode.com/problems/reverse-linked-list/
 */
public class P62ReverseLinkedList {

    public static void main(String[] args) {

        ListNode list = ListNode.create(1,2,3,4,5,6);
        ListNode.print(reverseList(list));
    }

    private static ListNode reverseList(ListNode head) {

        ListNode prev = null, cur = head, next = null;

        while(cur!=null){

            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;

        }

        return prev;

    }
}
