package Graphs;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MinMaxWtGraph {
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
        int parU = findUpar(u);
        int parV = findUpar(v);
        if(parU != parV){
            if(rank[parU] == rank[parV]){
                parent[parU] = parV;
                rank[parV]++ ;
            }else if(rank[parU] > rank[parV]){
                parent[parV] = parU ;
            }else{
                parent[parU] = parV ;
            }
        }
    }
    public boolean dsuCheck(List<PriorityQueue<Pair>> adjList , int[] edge){
        for(int i = 0 ; i < adjList.size() ; i++){
            int u = i ;
            for(Pair nei : adjList.get(u)){
                int v = nei.node ;
                int wt = nei.weight ;
                if(u == edge[0] && v == edge[1] && wt == edge[2]){
                    continue ;
                }else{
                    union(u , v);
                }
            }
        }
        //Checking if the components increased 
        for(int i = 0 ; i < parent.length-1 ; i++){
            if(parent[i] != parent[i+1]){
                return false ;
            }
        }
        return true ;
    }
    public int minMaxWeight(int n, int[][] edges, int threshold) {
        Arrays.sort(edges, (a, b) -> b[2] - a[2]);
        int min = -1;

        for (int i = 0; i < edges.length; i++) {
            if (solve(n, edges, threshold, i)) {
                min = edges[i][2]; 
            } else {
                break;
            }
        }

        return min;
    }
    private static boolean solve(int n, int[][] edges, int threshold, int start) {
        UnionFind uf = new UnionFind(n);
        int[] out = new int[n];
        for (int i = start; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            if (out[u] < threshold && out[v] < threshold) {
                out[v]++;
                out[u]++;
                uf.union(u, v);
            }
        }
        for (int i = 1; i < n; i++) {
            if (!uf.isConnected(0, i)) {
                return false;
            }
        }

        return true;
    }
    static class UnionFind {
        private int[] parent, rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if(parent[x] == x) return x ;
            return parent[x] = find(parent[x]);
        }

        public void union(int x, int y) {
            int rootX = find(x), rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }
    // public int minMaxWeightII(int n, int[][] edges, int threshold) {
    //     // remove those edge that are 
    //     //     maximum weighted 
    //     //     more than threshold to a vertex
    //     List<PriorityQueue<Pair>> adjList = new ArrayList<>();
    //     for(int i = 0 ; i < n ; i++){
    //         adjList.add(new PriorityQueue<>((a , b) -> b.weight - a.weight));
    //     }
    //     for(int[] edge : edges){
    //         adjList.get(edge[0]).add(new Pair(edge[1] , edge[2]));
    //     }

    //     for(int i = 0 ; i < n ; i++){
    //         int u = i ;
    //         while(!adjList.get(u).isEmpty()){
    //             Pair p = adjList.get(u).poll();
    //             if(dsuCheck(adjList , new int[]{u , p.node , p.weight})){
    //                 //If not a critical edge ;
    //                 //Then we can remain it polled 
    //                 continue ;
    //             }else{
    //                 adjList.get(u).offer(p);
    //             }
    //         }
    //     }
        

    class Pair{
        int node ; 
        int weight ; 
        public Pair(int n, int w){
            this.node = n ;
            this.weight = w ; 
        }
    }
}
}
