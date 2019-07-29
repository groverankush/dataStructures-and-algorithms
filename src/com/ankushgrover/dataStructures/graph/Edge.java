package com.ankushgrover.dataStructures.graph;

public class Edge<T> {

    Vertex<T> to;
    Vertex<T> from;
    private int weight;

    public Edge(Vertex<T> to, Vertex<T> from, int weight) {
        this.to = to;
        this.from = from;
        this.weight = weight;
    }

    public Edge(Vertex<T> to, Vertex<T> from) {
        this.to = to;
        this.from = from;
        this.weight = 1;
    }

    public Edge(T to, T from) {
        this.to = new Vertex<T>(to);
        this.from = new Vertex<T>(from);
    }

    @Override
    public String toString() {
        return "(" + this.to.value + ", " + this.from.value + ")";
    }
}
