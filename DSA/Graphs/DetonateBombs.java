package Graphs;

import java.util.ArrayList;
import java.util.List;

public class DetonateBombs {
    
class Solution {
    public int maximumDetonation(int[][] bombs) {
        //Approach will be to make a graph 
        //Reachibility will be checked by
        //(x-x1)^2 + (y-y1)^2 > r^2 this means point is outside 
        //(x-x1)^2 + (y-y1)^2 <= r^2 this means point is inside
        int n = bombs.length;
        List<List<Integer>> adjList = new ArrayList<>();

        // Build adjacency list
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                if (i != j && checkConnectivity(bombs[i], bombs[j])) {
                    adjList.get(i).add(j);
                }
            }
        }

        // Perform DFS for each bomb
        int maxDetonations = 0;
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            maxDetonations = Math.max(maxDetonations, dfs(i, adjList, visited));
        }

        return maxDetonations;
    }

    private int dfs(int node, List<List<Integer>> adjList, boolean[] visited) {
        visited[node] = true;
        int count = 1; // Count the current bomb
        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                count += dfs(neighbor, adjList, visited);
            }
        }
        return count;
    }

    private boolean checkConnectivity(int[] bomb1, int[] bomb2) {
        long dx = bomb1[0] - bomb2[0];
        long dy = bomb1[1] - bomb2[1];
        long distSq = dx * dx + dy * dy;
        long radiusSq = (long) bomb1[2] * bomb1[2];
        return distSq <= radiusSq;
    }
}
}
