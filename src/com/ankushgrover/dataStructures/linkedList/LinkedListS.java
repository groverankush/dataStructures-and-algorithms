package com.ankushgrover.dataStructures.linkedList;


import com.ankushgrover.dataStructures.nodes.Node;

/**
 * Singly Linked List representation
 *
 * @param <T>
 */
public class LinkedListS<T> {

    private Node head;

    public LinkedListS() {
        head = null;
    }

    public void add(T value) {
        Node node = new Node(value, null);
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    public void delete() {
        if (head == null)
            return;

        head = head.next;
    }

    public void display() {
        Node node = head;
        while (node != null) {
            System.out.println((T) node.data);
            node = node.next;
        }
    }


    private Node findLast() {
        Node node = head;
        while (node.next != null) {
            node = node.next;
        }
        return node;
    }

}
