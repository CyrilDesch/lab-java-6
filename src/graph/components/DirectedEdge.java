package graph.components;

public class DirectedEdge extends Edge {

    /**
     * Generate a Directed edge
     *
     * @param color : Color of the edge
     * @param value : value of the edge
     * @param ends  : vertex started from the edge
     */
    public DirectedEdge(String color, Double value, Vertex[] ends) {
        super(color, value, ends);
    }

    /**
     * @return the start of the edge
     */
    public Vertex getSource() {
        return this.ends[0];
    }

    /**
     * @return the end of the edge
     */
    public Vertex getSink() {
        return this.ends[1];
    }
}
