package com.ankushgrover.dataStructures.graph.implementation;

import com.ankushgrover.dataStructures.graph.models.Edge;

public interface IGraph<T> {

    void removeVertex(T vertex);

    void addEdge(Edge<T> edge);

    void addEdge(T to, T from);

    void print();
}
