package com.ankushgrover.problems;

import com.ankushgrover.dataStructures.nodes.ListNode;

import java.util.ArrayList;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 20/08/20
 * <p>
 * https://leetcode.com/problems/reorder-list/
 * <p>
 * #medium #linkedList
 */
public class P212LCMReorderList {

    public static void main(String[] args) {
    }

    public void reorderList(ListNode head) {

        if (head == null)
            return;

        ArrayList<ListNode> nodes = new ArrayList<>();
        ListNode node = head;

        while (node != null) {
            nodes.add(node);
            node = node.next;
        }

        int start = 0;
        int end = nodes.size() - 1;

        while (start < end) {

            ListNode temp = nodes.get(start++);
            nodes.get(end).next = nodes.get(start);
            temp.next = nodes.get(end--);


        }
        nodes.get(nodes.size() % 2 == 0 ? end + 1 : end).next = null;
    }
}
