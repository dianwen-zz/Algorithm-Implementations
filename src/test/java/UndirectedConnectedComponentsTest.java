package test.java;

import main.java.UndirectedConnectedComponents;
import main.resources.Graph;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by dianwen on 5/20/15.
 */
public class UndirectedConnectedComponentsTest {
    @Test
    public void testFindConnectedComponents() {
        Integer[][] adjacencyMatrix = {{1, 2, 3}, {0, 2, 3}, {0, 1, 4}, {0, 1, 4, 5}, {2, 3, 5}, {3, 4}, {7}, {6}, {9, 10}, {8, 10}, {8, 9}};
        Graph g = new Graph(adjacencyMatrix);
        List<List<Integer>> connectedComponents = UndirectedConnectedComponents.findConnectedComponents(g);
        assertEquals("Correct number of connected components", 3, connectedComponents.size());
        assertTrue(connectedComponents.contains(Arrays.asList(0, 1, 2, 3, 4, 5)));
        assertTrue(connectedComponents.contains(Arrays.asList(6, 7)));
        assertTrue(connectedComponents.contains(Arrays.asList(8, 9, 10)));
    }

}
