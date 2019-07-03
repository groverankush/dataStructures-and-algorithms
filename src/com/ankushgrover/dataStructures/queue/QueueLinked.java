package com.ankushgrover.dataStructures.queue;


import com.ankushgrover.dataStructures.nodes.NodeD;

/**
 * Queue Representation using doubly linked list
 *
 * @param <T>
 */
public class QueueLinked<T> {

    private NodeD front;
    private NodeD rear;

    public QueueLinked() {
        front = null;
        rear = null;
    }

    public void queue(T element) {
        NodeD node = new NodeD(element, null, null);

        if (front == null) {
            front = node;
            rear = node;
        } else {
            rear.next = node;
            node.prev = rear;
            rear = node;
        }
    }

    public T deQueue() {


        Object value = null;

        if (front != null) {
            value = front.value;
            front = front.next;
            if (front != null)
                front.prev = null;
        }
        return (T) value;
    }

}

