package com.ankushgrover.dataStructures.stack;

/**
 * Stack Contract
 * @param <T>
 */
public interface IStack<T> {
    void push(T value);

    T pop();
}
