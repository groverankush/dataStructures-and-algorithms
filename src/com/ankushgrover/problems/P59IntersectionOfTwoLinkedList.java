package com.ankushgrover.problems;

import com.ankushgrover.dataStructures.nodes.ListNode;

import java.util.HashMap;

/**
 * Created by Ankush Grover(ankush.dev2@gmail.com) on 26/08/19
 *
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 */
public class P59IntersectionOfTwoLinkedList {

    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(1,2);

        for(int i : map.keySet()){

        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int l1 = 0, l2 = 0;

        ListNode a = headA, b = headB;

        while(true){
            if(a!=null){
                l1++;
                a = a.next;
            }

            if(b!=null){
                l2++;
                b = b.next;
            }
            if(a == null && b == null)
                break;
        }

        if(l1>l2){
            a = headA;
            b = headB;
        }
        else{
            a = headB;
            b = headA;
        }

        for(int i = 0; i < Math.abs(l1-l2); i++){
            a = a.next;
        }

        while(a!=null && b!=null){
            if(a == b)
                return a;
            a = a.next;
            b = b.next;
        }

        return null;
    }
}
