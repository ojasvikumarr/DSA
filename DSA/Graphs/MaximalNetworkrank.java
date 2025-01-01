package Graphs;

import java.util.ArrayList;
import java.util.List;

public class MaximalNetworkrank {
    class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] indegree = new int[n];
        boolean[][] connections = new boolean[n][n];
        for(int[]road : roads){
            int u = road[0];
            int v = road[1];
            indegree[u]++ ;
            indegree[v]++ ;
            connections[u][v] = true ;
            connections[v][u] = true ;
        }
        int maxi = 0 ; 
        for(int i = 0 ; i < n ; i++)
            for(int j = i+1 ; j < n ; j++){
                maxi = Math.max(maxi , indegree[i] + indegree[j] - (connections[i][j] ? 1 : 0));
            }
        return maxi ;
    }
    @SuppressWarnings("unused")
    public int maximalNetworkRankII(int n, int[][] roads) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) adjList.add(new ArrayList<>());

        // O(V) in creating adjList 
        for(int[] road : roads){
            int u = road[0];
            int v = road[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        // O(E^2*(2V)) for creating all possible pairs and then tracking their neighbors
        int maxi = 0 ; 
        for(int i = 0 ; i < n ; i++)
            for(int j = i+1 ; j < n ; j++){
                int a = i ;
                int b = j ;
                int bridges = 0 ; 
                for(Integer neighbor : adjList.get(a)){
                    bridges++ ;
                }
                for(Integer neighbor : adjList.get(b)){
                    if(neighbor == a) continue ;
                    bridges++ ;
                }
                maxi = Math.max(maxi , bridges);
            }
        
        return maxi ;
    }

}
}
