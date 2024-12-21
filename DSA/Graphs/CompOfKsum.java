package Graphs;

import java.util.ArrayList;
import java.util.List;

public class CompOfKsum {
    class Solution {
    int[] parent ; 
    int[] rank ; 
    public void init(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i = 0 ; i < n ; i++) parent[i] = i ; 
    }
    public int findUpar(int x){
        if(parent[x] == x) return x ;
        return parent[x] = findUpar(parent[x]);
    }
    public void union(int u , int v){
        int uPar = findUpar(u);
        int vPar = findUpar(v);
        if(rank[uPar] == rank[vPar]){
            parent[uPar] = vPar ; 
            rank[vPar]++ ;
        }else if(rank[uPar] > rank[vPar]){
            parent[vPar] = uPar ;
        }else{
            parent[uPar] = vPar ;
        }
    }

    private int components ;
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> adjList = new ArrayList<>();
        components = 0 ; 
        for(int i = 0 ; i < n ;i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        dfs(0 , adjList , new boolean[n] , k , values);
        return components ;
    }
    public int dfs(int src, List<List<Integer>> adjList , boolean[] visited , int k , int[] values){
        visited[src] = true ;
        int sum = 0;
        for(Integer neighbor : adjList.get(src)){
            if(!visited[neighbor]){
                sum += dfs(neighbor , adjList , visited  , k , values);
                sum %= k ;
            }
        }

        sum += values[src];
        if(sum % k == 0) components++ ;
        return sum ;
    }
}
}
