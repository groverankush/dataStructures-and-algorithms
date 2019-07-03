package com.ankushgrover.dataStructures.stack;

/**
 * Stack representation using arrays.
 *
 * @param <T>
 */
public class StackArray<T> implements IStack {

    private Object[] arr;
    private int size;
    private int top;

    public StackArray(int size) {
        this.top = 0;
        this.size = size;
        arr = new Object[this.size];
    }

    @Override
    public void push(Object value) {
        if (top < arr.length) {
            arr[top++] = value;
        }
    }

    @Override
    public T pop() {

        if (top > 0)
            return (T) arr[--top];
        return null;
    }
}
