package graph.components;

import java.util.UUID;

public class Vertex {
    String id;
    String info;
    String color;

    /**
     * Generate a Vertex
     * @param info : Object
     * @param color : Color of vertex
     */
    public Vertex(String info, String color) {
        this.id = UUID.randomUUID().toString();
        this.info = info;
        this.color = color;
    }
}
