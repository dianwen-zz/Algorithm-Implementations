package main.java;

import main.resources.Graph;

import java.util.Arrays;

/**
 * Created by dianwen on 5/19/15.
 */
public class TopologicalSort {
    int currentLabel;
    int[] sortedGraph; // The index corresponds to the vertex and the value at the index corresponds to the topological value
    boolean[] visited;

    public int[] topoSort(Graph g) {
        currentLabel = g.getVerticiesCount();
        sortedGraph = new int[g.getVerticiesCount()];
        visited = new boolean[g.getVerticiesCount()];
        for(int i = 0; i < g.getVerticiesCount(); i++) {
            if(!visited[i]) {
                customDfs(g, i);
            }
        }
        return sortedGraph;
    }

    private void customDfs(Graph g, int vertex) {
        visited[vertex] = true;
        for(int v : g.getNeighboringVerticies(vertex)) {
            if(!visited[v]) {
                customDfs(g, v);
            }
        }
        sortedGraph[vertex] = currentLabel;
        currentLabel--;
    }

    public static void main(String[] args) {
        Integer[][] adjacencyMatrix = {{1, 2}, {3}, {3}, {}};
        Graph g = new Graph(adjacencyMatrix);
        TopologicalSort sort = new TopologicalSort();
        System.out.println(Arrays.toString(sort.topoSort(g)));
    }
}
