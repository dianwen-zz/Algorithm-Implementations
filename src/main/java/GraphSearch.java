package main.java;

import main.resources.Graph;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by dianwen on 5/18/15.
 */
public class GraphSearch {
    boolean[] visited;

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

    public void dfs(Graph g, int vertex) {
        visited = new boolean[g.getVerticiesCount()];
        dfsHelper(g, vertex);
    }

    private void dfsHelper(Graph g, int vertex) {
        visited[vertex] = true;
        System.out.println(vertex);
        for(int v : g.getNeighboringVerticies(vertex)) {
            if(!visited[v]) {
                dfsHelper(g, v);
            }
        }
    }

    public static void bfs2(Graph g, int vertex) {
        boolean[] visited = new boolean[g.getVerticiesCount()];
        Queue<Integer> toVisit = new PriorityQueue<>();
        toVisit.add(vertex);
        while(!toVisit.isEmpty()) {
            Integer removedVertex = toVisit.remove();
            if(!visited[removedVertex]) {
                visited[removedVertex] = true;
                System.out.println(removedVertex);
                for(int v : g.getNeighboringVerticies(removedVertex)) {
                        toVisit.add(v);
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[][] adjacencyMatrix = {{1, 2}, {0, 3}, {0, 3, 4}, {1, 2, 5}, {2, 5}, {3, 4}};
        Graph g = new Graph(adjacencyMatrix);
        System.out.println("BFS:");
        bfs2(g, 0);
        System.out.println("\nDFS:");
        GraphSearch search = new GraphSearch();
        search.dfs(g, 0);

    }
}
