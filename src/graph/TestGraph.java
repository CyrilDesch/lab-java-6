package graph;

import graph.components.Vertex;

public class TestGraph {
    public static void main(String[] args) {
        UndirectedGraph graph = new UndirectedGraph();
        Vertex vertex1 = new Vertex("a", "white");
        Vertex vertex2 = new Vertex("b", "white");
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);

        graph.addEdge(vertex1, vertex2);
        graph.addEdge(vertex1, vertex1);
        graph.addEdge(vertex2, vertex2);

        System.out.println(graph);
        System.out.println(graph.isConnected());
    }
}
