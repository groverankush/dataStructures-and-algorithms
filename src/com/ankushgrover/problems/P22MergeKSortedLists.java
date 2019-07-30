package com.ankushgrover.problems;

import com.ankushgrover.dataStructures.nodes.ListNode;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class P22MergeKSortedLists {

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[4];

        lists[0] = ListNode.create(2, 4, 5, 6, 7);
        lists[1] = ListNode.create(55);
        lists[2] = ListNode.create(4, 7, 9, 23, 45, 56, 78, 123);
        lists[3] = ListNode.create(0, 1);

        lists[0] = null;
        lists[1] = null;
        lists[2] = null;
        lists[3] = null;

        ListNode.print(mergeKLists(lists));
    }

    private static ListNode merge(ListNode l1, ListNode l2) {

        ListNode result;
        ListNode node;

        if (l1 == null)
            return l2;

        if (l2 == null)
            return l1;

        if (l1.val > l2.val) {
            result = l2;
            l2 = l2.next;
        } else {
            result = l1;
            l1 = l1.next;
        }

        node = result;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                node.next = l2;
                l2 = l2.next;
            } else {
                node.next = l1;
                l1 = l1.next;
            }
            node = node.next;
        }

        if (l1 != null) {
            node.next = l1;
        }

        if (l2 != null) {
            node.next = l2;
        }

        return result;
    }

    public static ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0)
            return null;

        if (lists.length == 1)
            return lists[0];

        ListNode result = lists[0];

        for (int i = 1; i < lists.length; i++) {
            result = merge(result, lists[i]);
        }
        return result;

    }
}
