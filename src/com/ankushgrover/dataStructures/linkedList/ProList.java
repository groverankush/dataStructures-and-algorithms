package com.ankushgrover.dataStructures.linkedList;


import com.ankushgrover.dataStructures.nodes.NodeD;

/**
 * Does some thing I required at the time. Named it pro! :P
 * @param <T>
 */
public class ProList<T> {

    private NodeD first;
    private NodeD last;

    public ProList() {
        first = null;
        last = null;
    }

    public void push(T element) {
        NodeD node = new NodeD(element, null, null);
        if (first == null) {
            first = node;
            last = node;
        } else {
            last.next = node;
            node.prev = last;
            last = node;
        }
    }

    public T getFirst(){
        if(first == null)
            return null;

        return (T) first.value;
    }

    public T getLast(){
        if(last == null)
            return null;

        return (T) last.value;
    }

    public T unlinkFirst() {
        if (first == null)
            return null;

        NodeD node = first;

        if (first.next != null) {
            NodeD sec = first.next;
            sec.prev = null;
            first = sec;
        }

        return (T) node.value;
    }

    public T pop() {
        if (last == null)
            return null;

        NodeD node = last;
        if (node.prev != null) {
            node.prev.next = null;
        }
        last = node.prev;
        return (T) node.value;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        NodeD node = first;
        while (node != null) {
            builder.append(node.value);
            builder.append("->");
            node = node.next;
        }
        builder.delete(builder.length() - 3, builder.length() - 1);

        return builder.toString();
    }
}
