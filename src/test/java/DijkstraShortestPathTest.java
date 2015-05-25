package test.java;

import main.java.DijkstraShortestPath;
import main.resources.Graph;
import org.junit.Test;

import static test.resources.Assertx.assertArrayEquals;

/**
 * Created by dianwen on 5/25/15.
 */
public class DijkstraShortestPathTest {
    @Test
    public void testShortestPath() {
        Integer[][] adjacencyMatrix = {{1, 2}, {2, 3}, {3}, {}};
        Integer[][] edgeWeights = {{1, 4}, {2, 6}, {3}, {}};
        Graph g = new Graph(adjacencyMatrix, edgeWeights);
        int[] shortestPaths = DijkstraShortestPath.findShortestPath(g, 0);
        int[] actualShortestPaths = {0, 1, 3, 6};
        assertArrayEquals(actualShortestPaths, shortestPaths);
    }
}
