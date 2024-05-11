package org.kylin.graph;

import java.util.List;

/**
 * Graph Vertex
 */
public class Vertex {

    String name;
    List<Edge> edges;

    public Vertex(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
