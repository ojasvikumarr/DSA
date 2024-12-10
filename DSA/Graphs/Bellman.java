package Graphs;

import java.util.Arrays;

public class Bellman {
    static int[] bellmanFord(int V, int[][] edges, int src) {
        // Write your code here
        int[] dist = new int[V];
        Arrays.fill(dist , (int)1e8);
        dist[src] = 0 ;
        for(int i = 0 ; i < V ; i++){
            for(int[] edge : edges){
                int source = edge[0];
                int dest = edge[1];
                int wt = edge[2];
                if(dist[source] != 1e8 && dist[source] + wt < dist[dest]){
                    dist[dest] = dist[source] + wt ; 
                    if(i == V-1){
                        return new int[]{-1} ; 
                    }
                }
                
            }
        }
        return dist ;
    }
}
