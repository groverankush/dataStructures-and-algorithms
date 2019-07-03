package com.ankushgrover.dataStructures.hash;

import com.ankushgrover.dataStructures.nodes.NodeM;

/**
 * Custom Hash Table representation
 *
 * @param <T>
 */
public class HashTableC<T> {

    private int size = 8;
    private NodeM[] arr;

    public HashTableC() {
        arr = new NodeM[size];

        for (int i = 0; i < size; i++) {
            arr[i] = new NodeM();
        }
    }

    public int getIndex(int key) {
        return key % size;
    }

    public void put(int key, T value) {
        NodeM n = new NodeM(key, value);
        int index = getIndex(key);

        NodeM node = arr[index];
        n.next = node.next;
        node.next = n;
    }

    public T get(int key) {
        Object value = null;
        int index = getIndex(key);
        NodeM node = arr[index].next;

        while (node != null) {
            if (node.key == key) {
                value = node.value;
                break;
            }

            node = node.next;
        }

        return (T) value;
    }

}
