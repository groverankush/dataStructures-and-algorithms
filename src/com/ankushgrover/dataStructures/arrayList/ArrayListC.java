package com.ankushgrover.dataStructures.arrayList;

/**
 * Custom array list representation
 *
 * @param <T>
 */
public class ArrayListC<T> {

    private int top;
    private Object[] array;

    public ArrayListC() {
        top = 0;
        array = new Object[1];
    }

    public int getSize() {
        return array.length;
    }

    public T get(int index) {
        return (T) array[index];
    }

    public void put(T element) {
        checkCapacity();
        array[top++] = element;
    }

    private void checkCapacity() {
        if (top >= getSize()) {
            doubleArray();
        }
    }

    private void doubleArray() {
        Object[] arr = new Object[getSize() * 2];
        for (int i = 0; i < getSize(); i++) {
            arr[i] = array[i];
        }
        array = arr;
    }


}
