package Graphs;

import java.util.ArrayList;
import java.util.List;

public class unReachablePairs {
    class Solution {
    public long countPairs(int n, int[][] edges) {
        List<Integer> comp = new ArrayList<>();
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) adjList.add(new ArrayList<>());
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        boolean[] vis = new boolean[n];
        for(int i = 0 ; i < n ; i++){
            if(vis[i] == false){
                vis[i] = true ; 
                comp.add(solve(adjList , i , vis));
            }
        }
        // long result  = 0 ; 
        // for(int i = 0 ; i < comp.size() ; i++){
        //     for(int j = i+1 ; j < comp.size() ;j++){
        //         result = result + comp.get(i)*comp.get(j) ; 
        //     }
        // }
        // return result ; 
        long totalPairs = (long)n*(n-1)/2 ;
        long sameCompPairs = 0 ; 
        for(int size : comp){
            sameCompPairs += (long) size * (size-1) /2 ; 
        }
        return totalPairs - sameCompPairs ;
    }
    public int solve(List<List<Integer>> adjList , int src , boolean[] vis){
        int nodes = 1 ; 
        for(Integer neighbor : adjList.get(src)){
            if(vis[neighbor] == false){
                vis[neighbor] = true ;
                nodes += solve(adjList , neighbor , vis);
            }
        }
        return nodes ;
    }

}
}
