package com.ankushgrover.problems;

import com.ankushgrover.dataStructures.nodes.ListNode;

public class P19MergeSortedList {

    public static void main(String[] args) {
        ListNode l1 = ListNode.create(2,4,6,7);
        ListNode l2 = ListNode.create(1,2,3,4);

        //ListNode.print(l1);

        //ListNode.print(l2);

        ListNode.print(merge(l1, l2));
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

        if(l1!=null){
            node.next = l1;
        }

        if(l2!=null){
            node.next = l2;
        }

        return result;
    }
}
