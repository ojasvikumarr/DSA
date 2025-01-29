package LeetCode;

import java.util.ArrayList;

public class Day113 {
    class Solution {
    // public int[] findRedundantConnectionII(int[][] edges) {
    //     ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
    //     int v = edges.length ; 
    //     for(int i = 0 ; i < v ; i++){
    //         adjList.add(new ArrayList<>());
    //     }
    //     for(int[] edge : edges){
    //         adjList.get(edge[0]-1).add(edge[1]-1);
    //         adjList.get(edge[1]-1).add(edge[0]-1);
    //     }
    // }
    public boolean checkCycle(ArrayList<ArrayList<Integer>> adjList , boolean[] visited , int src , int parent){
        visited[src] = true ; 
        for(Integer neighbor : adjList.get(src)){
            if(!visited[neighbor]){
                checkCycle(adjList , visited , neighbor , src);
            }else if(parent != neighbor && visited[neighbor]){
                return false ;
            }
        }
        return true ;
    }

    int[] parent ;
    int[] rank ; 
    public void init(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i = 0 ; i < n ; i++){
            parent[i] = i ;
        }
    }
    public int findUpar(int x){
        if(parent[x] == x) return x ;
        return parent[x] = findUpar(parent[x]);
    }
    public void union(int u , int v){
        int parU = findUpar(u);
        int parV = findUpar(v);
        if(rank[parU] == rank[parV]){
            parent[parU] = parV ; 
            rank[parV]++ ;
        }else if(rank[parU] > rank[parV]){
            parent[parV] = parU ; 
        }else{
            parent[parU] = parV ;
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int V = edges.length ; 
        init(V+1);
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            if(findUpar(u) == findUpar(v)){
                return edge ;
            }
            union(u , v);
        }
        return new int[]{0,0};
    }
}
}
