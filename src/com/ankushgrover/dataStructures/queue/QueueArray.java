package com.ankushgrover.dataStructures.queue;

/**
 * Queue representation using arrays
 *
 * @param <T>
 */
public class QueueArray<T> implements IQueue {

    private int rear;
    private int front;
    private Object[] arr;

    public QueueArray(int size) {
        rear = 0;
        front = 0;
        arr = new Object[size];
    }

    public boolean isFull() {
        return (rear == arr.length);
    }

    public boolean isEmpty() {
        return (front == rear);
    }


    @Override
    public void queue(Object element) {


        if (isFull())
            return;
        arr[rear++] = element;

    }

    public T deQueue() {
        if (isEmpty())
            return null;
        return (T) arr[front++];
    }

}
