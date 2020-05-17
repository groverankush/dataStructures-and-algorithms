package com.ankushgrover.interview;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 17/05/20
 * <p>
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
 * <p>
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2->3->4->5->NULL
 * Output: 1->3->5->2->4->NULL
 * Example 2:
 * <p>
 * Input: 2->1->3->5->6->4->7->NULL
 * Output: 2->3->6->7->1->5->4->NULL
 * Note:
 * <p>
 * The relative order inside both the even and odd groups should remain as it was in the input.
 * The first node is considered odd, the second node even and so on ...
 */
public class P152OddEvenLinkedList {

    public static void main(String[] args) {
    }

    public ListNode oddEvenList(ListNode head) {

        if (head == null)
            return null;

        ListNode odd = head;
        ListNode oddCurrent = odd;
        ListNode even = head == null ? null : head.next;
        ListNode evenCurrent = even;

        ListNode node = even == null ? null : even.next;

        boolean isOdd = true;

        while (node != null) {
            if (isOdd) {
                oddCurrent.next = node;
                oddCurrent = node;
            } else {
                evenCurrent.next = node;
                evenCurrent = node;
            }

            isOdd = !isOdd;
            node = node.next;
        }
        if (evenCurrent != null)
            evenCurrent.next = null;

        oddCurrent.next = even;
        return odd;

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
