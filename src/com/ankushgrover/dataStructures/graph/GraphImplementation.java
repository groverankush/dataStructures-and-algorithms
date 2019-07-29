package com.ankushgrover.dataStructures.graph;

public class GraphImplementation {

    public static void main(String[] args) {

        GraphWithEdgeList<Integer> graph = new GraphWithEdgeList<>();
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 6);

        graph.print();

        graph.addEdge(3, 4);
        graph.addEdge(3, 6);

        graph.print();

        System.out.println("*****************************************************************************");

        GraphAdjacencyMatrix<Integer> graph1 = new GraphAdjacencyMatrix<>();
        graph1.addEdge(1, 2);
        graph1.addEdge(1, 3);
        graph1.addEdge(1, 4);
        graph1.addEdge(2, 3);
        graph1.addEdge(2, 4);
        graph1.addEdge(2, 6);

        graph1.print();

        graph1.addEdge(3, 4);
        graph1.addEdge(3, 6);

        graph1.print();


    }
}
