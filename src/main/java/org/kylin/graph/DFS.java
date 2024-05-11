package org.kylin.graph;

import org.junit.Test;
import org.kylin.utils.ColorfulPrintUtil;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * <img src="./graph-1.png" alt="graph-dfs"/>
 */
public class DFS {

    @Test
    public void TestDFS() {
        Vertex v1 = new Vertex("V1");
        Vertex v2 = new Vertex("V2");
        Vertex v3 = new Vertex("V3");
        Vertex v4 = new Vertex("V4");
        Vertex v5 = new Vertex("V5");
        Vertex v6 = new Vertex("V6");

        v1.edges = Arrays.asList(
                new Edge(v3, 9),
                new Edge(v2, 7),
                new Edge(v6, 14)
        );
        v2.edges = Arrays.asList(new Edge(v4, 15));
        v3.edges = Arrays.asList(new Edge(v4, 11), new Edge(v6, 2));
        v4.edges = Arrays.asList(new Edge(v5, 6));
        v5.edges = Arrays.asList();
        v6.edges = Arrays.asList(new Edge(v5, 9));

        dfs(v1);
    }

    public static void dfs(Vertex v) {
        v.visited = true;
        ColorfulPrintUtil.printlnMagenta(v.name);

        for(Edge edge : v.edges) {
            if (!edge.linked.visited) {
                dfs(edge.linked);
            }
        }
    }
}
