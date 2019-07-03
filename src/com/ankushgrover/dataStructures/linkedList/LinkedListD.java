package com.ankushgrover.dataStructures.linkedList;


import com.ankushgrover.dataStructures.nodes.NodeD;

/**
 * Doubly linked list representation
 *
 * @param <T>
 */
public class LinkedListD<T> {
    private NodeD head;

    public LinkedListD() {
        head = null;
    }

    public void add(T element) {
        NodeD node = new NodeD(element, null, head);
        if (head == null) {
            head = node;
        } else {
            head.prev = node;
            head = node;
        }
    }

    public void delete() {
        if (head == null)
            return;

        head = head.next;
        head.prev = null;
    }

    public void display() {
        NodeD node = head;
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }
}
