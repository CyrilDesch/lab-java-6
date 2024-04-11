package graph;

import graph.components.DirectedEdge;
import graph.components.Edge;
import graph.components.Vertex;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class DirectedGraph extends Graph {

    // this.adjList have to contains edges twice, one for each direction

    @Override
    public void addEdge(Vertex startVertex, Vertex endVertex) {
        this.adjList.get(startVertex).add(new DirectedEdge("white", 1.0, new Vertex[]{startVertex, endVertex}));
    }

    @Override
    public List<Edge> getEdges(Vertex firstVertex, Vertex secondVertex) {
        List<Edge> firstVertexAdj = adjList.get(firstVertex).stream().filter(edge -> ((DirectedEdge) edge).getSink().equals(secondVertex)).toList();
        List<Edge> secondVertexAdj = adjList.get(secondVertex).stream().filter(edge -> ((DirectedEdge) edge).getSink().equals(firstVertex)).toList();
        return Stream.concat(firstVertexAdj.stream(), secondVertexAdj.stream()).toList();
    }

    @Override
    public List<Edge> getNeighborEdges(Vertex vertex) {
        Stream<Edge> firstVertexAdj = adjList.get(vertex).stream();
        // Get list of all edges that have the vertex as the end
        Stream<Edge> secondVertexAdj = adjList.values().stream().flatMap(Set::stream).filter(edge -> ((DirectedEdge) edge).getSink().equals(vertex));
        return Stream.concat(firstVertexAdj, secondVertexAdj).toList();
    }
}
