package graph;

import graph.components.Edge;
import graph.components.UndirectedEdge;
import graph.components.Vertex;

import java.util.List;

public class UndirectedGraph extends Graph {

    @Override
    public void addEdge(Vertex firstVertex, Vertex secondVertex) {
        UndirectedEdge newEdge = new UndirectedEdge("white", 1.0, new Vertex[]{firstVertex, secondVertex});
        this.adjList.get(firstVertex).add(newEdge);
        this.adjList.get(secondVertex).add(newEdge);
    }

    @Override
    public List<Edge> getEdges(Vertex firstVertex, Vertex secondVertex) {
        return adjList.get(firstVertex).stream().filter(edge -> edge.getEnds()[0].equals(secondVertex) || edge.getEnds()[1].equals(secondVertex)).toList();
    }

    @Override
    public List<Edge> getNeighborEdges(Vertex vertex) {
        return adjList.get(vertex).stream().toList();
    }
}
