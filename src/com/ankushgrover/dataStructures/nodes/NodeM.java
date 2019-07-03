package com.ankushgrover.dataStructures.nodes;

/**
 * Node for Hash Map
 */
public class NodeM {
    public int key;
    public Object value;
    public NodeM next;

    public NodeM(int key, Object value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }

    public NodeM() {
        this.next = null;
    }
}
