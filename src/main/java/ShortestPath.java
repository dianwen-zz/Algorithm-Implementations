package main.java;

import main.resources.Graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by dianwen on 5/20/15.
 */
public class ShortestPath {

    public static int findShortestPath(Graph g, int start, int end) {
        int[] minDistance = new int[g.getVerticiesCount()];
        minDistance[start] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()) {
            int currentVertex = q.remove();
            Integer[] neighbors = g.getNeighboringVerticies(currentVertex);
            for(int i : neighbors) {
                if(minDistance[i] == 0 && i != start) {
                    minDistance[i] = minDistance[currentVertex] + 1;
                    q.add(i);
                    if(i == end) {
                        return minDistance[i];
                    }
                }
            }
        }
        return -1;
    }
}
