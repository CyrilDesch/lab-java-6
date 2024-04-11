package graph.components;

public class UndirectedEdge extends Edge {

    /**
     * Generate an Undirected edge
     *
     * @param color : Color of the edge
     * @param value : value of the edge
     * @param ends  : vertex started from the edge
     */
    public UndirectedEdge(String color, Double value, Vertex[] ends) {
        super(color, value, ends);
    }

}
