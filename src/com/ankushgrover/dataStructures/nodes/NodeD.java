package com.ankushgrover.dataStructures.nodes;

/**
 * Node for doubly linked list.
 */
public class NodeD {
    public NodeD prev;
    public NodeD next;
    public Object value;

    public NodeD(Object value, NodeD prev, NodeD next) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }
}
