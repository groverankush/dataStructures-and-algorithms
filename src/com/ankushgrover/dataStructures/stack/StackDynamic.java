package com.ankushgrover.dataStructures.stack;

import java.util.Arrays;

/**
 * Stack representation using dynamic arrays
 *
 * @param <T>
 */
public class StackDynamic<T> implements IStack {

    private Object[] arr;
    private int top;

    public StackDynamic() {
        arr = new Object[1];
        top = 0;
    }

    private void checkCapacity() {
        if (top == arr.length) {
            arr = Arrays.copyOf(arr, arr.length * 2);
        }
    }

    @Override
    public void push(Object value) {
        checkCapacity();
        arr[top++] = value;
    }

    @Override
    public Object pop() {
        if (top > 0)
            return (T) arr[--top];
        return null;
    }
}
