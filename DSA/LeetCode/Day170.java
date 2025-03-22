package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Day170 {
    class Solution {
    int[] rank ; 
    int[] size ; 
    int[] parent ; 
    public void init(int n ){
        rank = new int[n];
        parent = new int[n];
        size = new int[n];
        for(int i = 0 ; i < n ; i++){
            parent[i] = i ; 
            size[i] = 1; 
        }
    }
    public int find(int x){
        if(parent[x] == x) return x ;
        return parent[x] = find(parent[x]);
    }
    public void union(int u , int v){
        int uPar = find(u);
        int vPar = find(v);
        if(uPar != vPar){
            // if(rank[uPar] == rank[vPar]){
            //     parent[uPar] = vPar ; 
            //     rank[vPar]++ ;
            // }else if(rank[uPar] > rank[vPar]){
            //     parent[vPar] = uPar ; 
            // }else{
            //     parent[uPar] = vPar ;
            // }
            if(size[uPar] > size[vPar]){
                parent[vPar] = uPar ; 
                size[uPar] += size[vPar];
            }else{
                parent[uPar] = vPar ; 
                size[vPar] += size[uPar];
            }
        }
    }
    public int countCompleteComponents(int n, int[][] edges) {
        init(n);

        // List<List<Integer>> adjList = new ArrayList<>();
        // for(int i = 0 ; i < n ; i++) adjList.add(new ArrayList<>());
        // for(int[] edge : edges){
        //     int u = edge[0];
        //     int v = edge[1];
        //     adjList.get(u).add(v);
        //     adjList.get(v).add(u);
        // }
        
        Map<Integer , Integer> map = new HashMap<>();
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            union(u , v);
        }
        // for(int i = 0 ; i < n; i++){
        //     int ultPar = find(i);
        //     map.putIfAbsent(ultPar , new ArrayList<>());
        //     map.get(ultPar).add(i);
        // }
        for(int[] edge : edges){
            int par = find(edge[0]);
            map.put(par , map.getOrDefault(par, 0)+1);
        }

        int res = 0 ;
        for(int i = 0 ; i < n; i++){
            if(find(i) == i){//that is it is the maste 
                int nodeCount = size[i];
                int expectedEdges = (nodeCount)*(nodeCount-1)/2 ;
                if(map.getOrDefault(i , 0) == expectedEdges){
                    res++ ;
                }
            }
        }

        return res ;
    }
    
}
}
