package org.kylin.graph;

import org.junit.Test;
import org.kylin.utils.ColorfulPrintUtil;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * <img src="./graph-1.png" alt="graph-dfs"/>
 */
public class BFS {

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

        bfs(v1);
    }

    /**
     * v1 -> v3 -> v2 -> v6 -> v4 -> v5
     */
    public static void bfs(Vertex v) {
        LinkedList<Vertex> queue = new LinkedList<>();
        queue.offer(v);
        v.visited = true;

        while (!queue.isEmpty()) {
            Vertex poll = queue.poll();
            ColorfulPrintUtil.printlnYellow(poll.name);
            for (Edge edge : poll.edges) {
                if (!edge.linked.visited) {
                    edge.linked.visited = true;
                    queue.offer(edge.linked);
                }
            }
        }
    }

}
