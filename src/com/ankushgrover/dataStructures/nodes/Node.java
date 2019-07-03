package com.ankushgrover.dataStructures.nodes;

/**
 * Sinple node representation for singly linked list.
 *
 * @param <T>
 */
public class Node<T> {

    public Object data;
    public Node next;

    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }


}
