package main.java;

import main.resources.Graph;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by dianwen on 5/24/15.
 */
public class DijkstraShortestPath {
    public static void main(String[] args) {
        Integer[][] adjacencyMatrix = {{1, 2}, {2, 3}, {3}, {}};
        Integer[][] edgeWeights = {{1, 4}, {2, 6}, {3}, {}};
        Graph g = new Graph(adjacencyMatrix, edgeWeights);
        System.out.println(Arrays.toString(findShortestPath(g, 0)));
    }

    public static int[] findShortestPath(Graph g, int startVertex) {
        int[] shortestPaths = new int[g.getVerticiesCount()];
        for(int i = 0; i < shortestPaths.length; i++) {
            shortestPaths[i] = Integer.MAX_VALUE;
        }
        shortestPaths[startVertex] = 0;
        Queue<Node> q = new PriorityQueue<>();
        q.add(new Node(startVertex, 0));

        while(!q.isEmpty()) {
            Node currentNode = q.remove();
            Integer[] neighbors = g.getNeighboringVerticies(currentNode.vertexId);
            for(int neighbor : neighbors) {
                int newNeighborDistance = currentNode.minDistance + g.getEdgeWeight(currentNode.vertexId, neighbor);
                if(newNeighborDistance < shortestPaths[neighbor]) {
                    shortestPaths[neighbor] = newNeighborDistance;
                    q.remove(new Node(neighbor));
                    q.add(new Node(neighbor, newNeighborDistance));
                }
            }

        }
        return shortestPaths;
    }

    public static class Node implements Comparable<Node>{
        int minDistance;
        int vertexId;

        public Node(int vertexId, int minDistance) {
            this.vertexId = vertexId;
            this.minDistance = minDistance;
        }

        public Node(int vertexId) {
            this(vertexId, Integer.MAX_VALUE);
        }

        @Override
        public int compareTo(Node that) {
            return this.minDistance - that.minDistance;
        }

        @Override
        public boolean equals(Object that) {
            if(that instanceof Node) {
                Node castedThat = (Node) that;
                return this.vertexId == castedThat.vertexId;
            }
            return false;
        }
    }
}
