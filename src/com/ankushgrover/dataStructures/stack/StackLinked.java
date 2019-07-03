package com.ankushgrover.dataStructures.stack;


import com.ankushgrover.dataStructures.nodes.Node;

/**
 * Stack representation using Linked list.
 *
 * @param <T>
 */
public class StackLinked<T> implements IStack {


    private Node top;

    public StackLinked() {

        top = null;
    }

    @Override
    public void push(Object value) {
        Node node = new Node(value, null);


        if (top == null) {
            top = node;
        } else {
            node.next = top;
            top = node;
        }
    }

    @Override
    public T pop() {
        T value = null;
        Node node = top;
        if (node != null) {
            value = (T) node.data;
            top = top.next;
        }


        return value;
    }
}
