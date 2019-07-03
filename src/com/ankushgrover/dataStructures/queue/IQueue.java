package com.ankushgrover.dataStructures.queue;

/**
 * Queue Contract
 *
 * @param <T>
 */
public interface IQueue<T> {

    void queue(T element);

    T deQueue();

}
