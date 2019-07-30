package com.ankushgrover.dataStructures.graph.implementation;

import com.ankushgrover.dataStructures.graph.models.Edge;

import java.util.ArrayList;
import java.util.HashMap;

public class GraphWithEdgeList<T> implements IGraph<T> {

    HashMap<T, ArrayList<T>> map;

    public GraphWithEdgeList() {
        this.map = new HashMap<>();
    }

    public GraphWithEdgeList(ArrayList<Edge<T>> edges) {
        map = new HashMap<>();
        for (Edge<T> edge : edges)
            addEdge(edge);

    }

    @Override
    public void removeVertex(Object vertex) {
        for (T v : map.keySet()) {
            if (v == vertex) {
                map.remove(v);
                break;
            }
        }

        for (T v : map.keySet()) {
            ArrayList<T> edges = map.get(v);
            edges.removeIf(edge -> edge == vertex);
        }
    }

    @Override
    public void addEdge(Edge<T> edge) {
        ArrayList<T> edgeList = map.get(edge.to.value);
        if (edgeList == null) {
            edgeList = new ArrayList<>();
        }
        edgeList.add(edge.from.value);
        if (!map.containsKey(edge.from.value))
            map.put(edge.from.value, new ArrayList<T>());
        map.put(edge.to.value, edgeList);
    }

    @Override
    public void addEdge(T to, T from) {
        addEdge(new Edge<T>(to, from));
    }

    @Override
    public void print() {
        for (T v : map.keySet()) {
            System.out.print(v + " -> ");
            System.out.println(map.get(v));
        }
    }

}
