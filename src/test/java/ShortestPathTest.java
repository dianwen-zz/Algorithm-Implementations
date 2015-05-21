package test.java;

import main.java.ShortestPath;
import main.resources.Graph;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by dianwen on 5/20/15.
 */
public class ShortestPathTest {
    @Test
    public void testShortestPath() {
        Integer[][] adjacencyMatrix = {{1, 2, 3}, {0, 2, 3}, {0, 1, 4}, {0, 1, 4, 5}, {2, 3, 5}, {3, 4}};
        Graph g = new Graph(adjacencyMatrix);
        assertEquals(2, ShortestPath.findShortestPath(g, 0, 5));
    }
}
