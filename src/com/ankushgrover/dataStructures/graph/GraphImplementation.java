package com.ankushgrover.dataStructures.graph;

public class GraphImplementation {

    public static void main(String[] args) {

        GraphWithList<Integer> graph = new GraphWithList<>();
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 6);

        graph.print();

        graph.addEdge(3,4);
        graph.addEdge(3,6);

        graph.print();


    }
}
