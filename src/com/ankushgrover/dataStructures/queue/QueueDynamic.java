package com.ankushgrover.dataStructures.queue;

import java.util.Arrays;

/**
 * Queue representation using dynamic array concept
 *
 * @param <T>
 */
public class QueueDynamic<T> {

    private int rear;
    private int front;
    private Object[] arr;

    public QueueDynamic() {
        arr = new Object[1];
        rear = 0;
        front = 0;
    }

    public int getSize() {
        return arr.length;
    }

    private void ensureCapacity() {
        if (rear == arr.length) {
            arr = Arrays.copyOf(arr, arr.length * 2);
        }
    }

    private boolean isEmpty() {
        return front == rear;
    }

    public void queue(T element) {
        ensureCapacity();
        arr[rear++] = element;
    }

    public T deQueue() {
        Object value = null;
        if (!isEmpty()) {
            value = arr[front++];
        }
        return (T) value;
    }

}

