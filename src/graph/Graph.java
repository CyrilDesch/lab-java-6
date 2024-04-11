package graph;

import graph.components.Edge;
import graph.components.Vertex;

import java.util.*;

abstract class Graph {
    final protected HashMap<Vertex, Set<Edge>> adjList;

    public Graph() {
        this.adjList = new HashMap<>();
    }

    /**
     * Get the number of verticies of the graph
     * @return number of verticies
     */
    public int nbOfVerticies() {
        return adjList.size();
    }

    /**
     * Get the number of edges stored in verticies of the graph
     * @return number of edges
     */
    public int nbOfEdges() {
        int sum = 0;
        for (Map.Entry<Vertex, Set<Edge>> entry : adjList.entrySet()) {
            sum += entry.getValue().size();
        }
        return sum;
    }

    /**
     * Add a vertex to the graph
     * @param vertex: vertex to be added
     */
    public void addVertex(Vertex vertex) {
        adjList.put(vertex, new HashSet<Edge>());
    };

    /**
     * Add an edge to the graph and connect vertices in adjacent list
     * @param startVertex : start vertex
     * @param endVertex : end vertex
     */
    public abstract void addEdge(Vertex startVertex, Vertex endVertex);

    /**
     * Check if two vertices are connected (there is a path)
     * @param firstVertex : first vertex
     * @param secondVertex : second vertex
     * @return true if connected, false otherwise
     */
    public boolean isConnected(Vertex firstVertex, Vertex secondVertex) {
        return adjList.get(firstVertex).stream().anyMatch(edge -> edge.getEnds()[1].equals(secondVertex) ) ||
                adjList.get(secondVertex).stream().anyMatch(edge -> edge.getEnds()[1].equals(firstVertex) );
    };

    /**
     * Check if the graph is connected (all vertices are connected)
     * @return true if connected, false otherwise
     */
    public boolean isConnected() {
        for (Vertex vertex1 : this.adjList.keySet()) {
            for (Vertex vertex2 : this.adjList.keySet()) {
                if (!isConnected(vertex1, vertex2)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Get the edges between two vertices
     * @param firstVertex : first vertex
     * @param secondVertex : second vertex
     */
    public abstract List<Edge> getEdges(Vertex firstVertex, Vertex secondVertex);

    /**
     * Get the edges of the graph
     * @return list of edges
     */
    public List<Edge> getEdges() {
        return adjList.values().stream().flatMap(Set::stream).toList();
    }

    /**
     * Get neighbor edges of a vertex (edges connected to this vertex)
     * @param vertex : vertex
     * @return list of edges
     */
    public abstract List<Edge> getNeighborEdges(Vertex vertex);

    @Override
    public String toString() {
        return "Graph{" +
                "adjList=" + adjList +
                '}';
    }
}
