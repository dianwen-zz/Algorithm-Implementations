package main.resources;

import java.util.Arrays;

/**
 * Created by dianwen on 5/18/15.
 */
public class Graph {
    Integer[][] adjacencyMatrix;
    Integer[][] weights;
    Integer edges;
    Integer verticies;

    public Graph(Integer[][] adjacencyMatrix) {
        this(adjacencyMatrix, new Integer[adjacencyMatrix.length][]);
    }

    public Graph(Integer[][] adjacencyMatrix, Integer[][] weights) {
        this.adjacencyMatrix = adjacencyMatrix;
        verticies = adjacencyMatrix.length;
        edges = 0;
        for(int i = 0; i < adjacencyMatrix.length; i++) {
            edges += adjacencyMatrix[i].length;
            if(weights[i] == null) {
                weights[i] = new Integer[adjacencyMatrix[i].length];
            }
        }
        this.weights = weights;
    }

    public Integer[] getNeighboringVerticies(int vertex) {
        return adjacencyMatrix[vertex];
    }

    public Integer getEdgeWeight(int vertexA, int vertexB) {
        int indexB = Arrays.asList(adjacencyMatrix[vertexA]).indexOf(vertexB);
        return weights[vertexA][indexB];
    }

    public Integer getEdgesCount() {
        return edges;
    }

    public Integer getVerticiesCount() {
        return verticies;
    }
}
