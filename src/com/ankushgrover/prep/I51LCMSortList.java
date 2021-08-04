package com.ankushgrover.prep;

import com.ankushgrover.dataStructures.nodes.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 08/07/21
 */
public class I51LCMSortList {

    public static void main(String[] args) {

        I51LCMSortList obj = new I51LCMSortList();
        ListNode node = ListNode.create(4, 2, 1, 3);

        ListNode res = obj.sortList(node);

        ListNode.print(res);

    }

    public ListNode sortList(ListNode head) {
        return approachPriorityQueue(head);
    }

    private ListNode approachPriorityQueue(ListNode head) {


        PriorityQueue<ListNode> q = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));

        ListNode node = head;
        ListNode res = new ListNode(Integer.MIN_VALUE);
        ListNode tail = res;
        while (node != null) {
            q.add(node);
            node = node.next;
        }

        while (!q.isEmpty()) {

            ListNode ordered = q.poll();
            tail.next = ordered;
            tail = tail.next;

        }

        tail.next = null;
        return res.next;

    }
}
