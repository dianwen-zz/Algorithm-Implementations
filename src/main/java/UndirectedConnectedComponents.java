package main.java;

import main.resources.Graph;

import java.util.*;

/**
 * Created by dianwen on 5/20/15.
 */
public class UndirectedConnectedComponents {
    private static List<Integer> bfs(Graph g, Set<Integer> visited, int start) {
        List<Integer> connected = new ArrayList<Integer>();
        visited.add(start);
        connected.add(start);
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()) {
            int currentVertex = q.remove();
            Integer[] neighbors = g.getNeighboringVerticies(currentVertex);
            for(int i : neighbors) {
                if(!visited.contains(i)) {
                    visited.add(i);
                    connected.add(i);
                    q.add(i);
                }
            }
        }
        return connected;
    }

    public static List<List<Integer>> findConnectedComponents(Graph g) {
        List<List<Integer>> connectedComponents = new ArrayList<>();
        Set<Integer> visited = new HashSet<Integer>();
        for(int i = 0; i < g.getVerticiesCount(); i++) {
            if(!visited.contains(i)) {
                connectedComponents.add(bfs(g, visited, i));
            }
        }
        return connectedComponents;
    }
}
