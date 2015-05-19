package main.java;

import main.resources.Graph;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by dianwen on 5/18/15.
 */
public class GraphSearch {
    public static void bfs(Graph g, int vertex) {
        boolean[] visited = new boolean[g.getVerticiesCount()];
        visited[vertex] = true;
        System.out.println(vertex);
        Queue<Integer> toVisit = new PriorityQueue<>();
        toVisit.add(vertex);
        while(!toVisit.isEmpty()) {
            Integer removedVertex = toVisit.remove();
            for(int v : g.getNeighboringVerticies(removedVertex)) {
                if(!visited[v]) {
                    toVisit.add(v);
                    visited[v] = true;
                    System.out.println(v);
                }
            }
        }
    }

    public static void dfs(Graph g, int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.println(vertex);
        for(int v : g.getNeighboringVerticies(vertex)) {
            if(!visited[v]) {
                dfs(g, v, visited);
            }
        }
    }

    public static void main(String[] args) {
        Integer[][] adjacencyMatrix = {{1, 2, 5}, {0, 2, 3, 5}, {0, 1, 3, 4}, {1, 2, 4}, {2, 3}, {0, 1}};
        Graph g = new Graph(adjacencyMatrix);
        System.out.println("BFS:");
        bfs(g, 5);
        System.out.println("\nDFS:");
        dfs(g, 5, new boolean[g.getVerticiesCount()]);

    }
}
