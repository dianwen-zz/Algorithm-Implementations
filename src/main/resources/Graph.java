package main.resources;

/**
 * Created by dianwen on 5/18/15.
 */
public class Graph {
    Integer[][] adjacencyMatrix;
    Integer edges;
    Integer verticies;

    public Graph(Integer[][] adjacencyMatrix) {
        this.adjacencyMatrix = adjacencyMatrix;
        verticies = adjacencyMatrix.length;
        edges = 0;
        for(int i = 0; i < adjacencyMatrix.length; i++) {
            edges += adjacencyMatrix[i].length;
        }
    }

    public Integer[] getNeighboringVerticies(int vertex) {
        return adjacencyMatrix[vertex];
    }

    public Integer getEdgesCount() {
        return edges;
    }

    public Integer getVerticiesCount() {
        return verticies;
    }
}
