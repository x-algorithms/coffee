package org.kylin.graph;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SimpleCase {

    /**
     *      B
     *    ↗    ↘
     *  A        D
     *    ↘    ↗
     *      C
     *
     */
    @Test
    public void TestCase() {
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        // List.of
        a.edges = Arrays.asList(new Edge(b), new Edge(c));
        b.edges = Arrays.asList(new Edge(d));
        c.edges = Arrays.asList(new Edge(d));
        d.edges = Arrays.asList();
    }
}
