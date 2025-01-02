package Graphs;

import java.util.Arrays;
import java.util.Comparator;

public class CheckpathExists {
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
        if(rank[parU] == rank[parV]){
            parent[parU] = parV ; 
            rank[parV]++ ;
        }else if(rank[parU] < rank[parV]){
            parent[parU] = parV ;
        }else{
            parent[parV] = parU ;
        }
    }
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        init(n);
        // Add query indices for sorting and tracking results
        int[][] extendedQueries = new int[queries.length][4];
        for (int i = 0; i < queries.length; i++) {
            extendedQueries[i][0] = queries[i][0];
            extendedQueries[i][1] = queries[i][1];
            extendedQueries[i][2] = queries[i][2];
            extendedQueries[i][3] = i; // Store original index
        }

        // Sort queries and edges by weight
        Arrays.sort(extendedQueries, Comparator.comparingInt(a -> a[2]));
        Arrays.sort(edgeList, Comparator.comparingInt(a -> a[2]));

        boolean[] result = new boolean[queries.length];
        int i = 0;

        for (int[] query : extendedQueries) {
            // Union edges with weights less than the current query limit
            while (i < edgeList.length && edgeList[i][2] < query[2]) {
                union(edgeList[i][0], edgeList[i][1]);
                i++;
            }
            // Check if the source and destination are connected
            result[query[3]] = findUpar(query[0]) == findUpar(query[1]);
        }

        return result;
    }
    
}
}
