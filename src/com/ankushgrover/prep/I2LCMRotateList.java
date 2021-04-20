package com.ankushgrover.prep;

import com.ankushgrover.dataStructures.nodes.ListNode;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 14/04/21
 * <p>
 * https://leetcode.com/problems/rotate-list/
 */
public class I2LCMRotateList {

    public static void main(String[] args) {

    }

    public ListNode rotateRight(ListNode head, int k) {

        int size = sizeOfList(head);
        return rotateList(head, size, k);
    }

    int sizeOfList(ListNode node) {
        int size = 0;
        while (node != null) {

            size++;
            node = node.next;

        }

        return size;
    }

    ListNode rotateList(ListNode head, int size, int rotations) {


        if (size == 0)
            return head;

        int actual = rotations % size;

        if (actual == 0)
            return head;

        int r = size - actual;
        int count = 0;
        ListNode node = head;
        ListNode prev = null;
        ListNode newHead = null;
        ListNode last = null;
        ListNode newLast = null;
        while (node != null) {

            if (count == r) {
                newLast = prev;
                newHead = node;
            }

            prev = node;
            node = node.next;

            if (node == null)
                last = prev;


            count++;

        }

        last.next = head;
        newLast.next = null;


        return newHead;

    }
}
