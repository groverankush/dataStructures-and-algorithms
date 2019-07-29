package com.ankushgrover.dataStructures.graph;

import com.ankushgrover.dataStructures.graph.models.Edge;

import java.util.HashMap;

public class GraphAdjacencyMatrix<T> implements IGraph<T> {

    private HashMap<T, Integer> map;
    private int maxIndex = 0;
    private int[][] arr = {};

    public GraphAdjacencyMatrix() {
        map = new HashMap<>();
    }

    @Override
    public void removeVertex(T vertex) {
        Integer index = map.get(vertex);

        if (index != null) {
            for (int i = 0; i < arr.length; i++) {
                arr[i][index] = 0;
                arr[index][i] = 0;
            }
        }

    }

    @Override
    public void addEdge(Edge<T> edge) {

    }

    @Override
    public void addEdge(T to, T from) {
        if (!canInsertEdge(to, from)) {
            resize(to, from);
        }
        Integer i, j;

        i = map.get(to);
        j = map.get(from);

        if (i == null) {
            i = maxIndex;
            map.put(to, maxIndex++);
        }
        if (j == null) {
            j = maxIndex;
            map.put(from, maxIndex++);
        }

        arr[i][j] = 1;
    }

    @Override
    public void print() {

        T[] keys = (T[]) new Object[arr.length];
        for (T key : map.keySet()) {
            keys[map.get(key)] = key;
        }

        System.out.print("*  ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(keys[i] + "  ");
        }
        System.out.println();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length + 1; j++) {
                if (j == 0) {
                    System.out.print(keys[i] + "  ");
                } else
                    System.out.print(arr[i][j - 1] + "  ");
            }
            System.out.println();
        }

    }

    private boolean canInsertEdge(T to, T from) {
        return map.containsKey(to) && map.containsKey(from);
    }

    private void resize(T to, T from) {
        int size = map.containsKey(to) ? 1 : 2;
        int[][] temp = new int[map.size() + size][map.size() + size];
        for (int i = 0; i < arr.length; i++) {
            System.arraycopy(arr[i], 0, temp[i], 0, arr.length);
        }
        arr = temp;
    }
}
