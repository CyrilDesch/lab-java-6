package graph.components;

import java.util.List;
import java.util.UUID;

public abstract class Edge {
    String id;
    String color;
    Double value;
    Vertex[] ends;

    /**
     * Generate an Edge
     * @param color : Color of the edge
     * @param value : value of the edge
     * @param ends : vertices of the edge (start and end)
     */
    public Edge(String color, Double value, Vertex[] ends) {
        this.id = UUID.randomUUID().toString();;
        this.color = color;
        this.value = value;
        this.ends = ends;
    }

    public Vertex[] getEnds() {
        return ends;
    }
}
