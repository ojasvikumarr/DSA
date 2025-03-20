package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Day167 {
    class Solution {
    int[] rank ;
    int[] parent ; 
    public void init(int n){
        rank = new int[n];
        parent = new int[n];
        for(int i = 0 ; i < n ; i++) parent[i] = i ; 
    }
    public int find(int x){
        if(parent[x] == x) return x ;
        return parent[x] = find(parent[x]);
    }
    public void union(int u , int v){
        int uPar = find(u);
        int vPar = find(v);
        if(uPar != vPar){
            if(rank[uPar] == rank[vPar]){
                parent[uPar] = vPar ; 
                rank[vPar]++ ;
            }else if(rank[uPar] > rank[vPar]){
                parent[vPar] = uPar ;
            }else{
                parent[uPar] = vPar ; 
            }
        }
    }
    public int[] minimumCost(int n, int[][] edges, int[][] queries) {
        //i need to form the dsu array 
        init(n);
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            union(u , v);
        }
        
        Map<Integer , Integer> map = new HashMap<>();
        for(int i = 0 ; i < n; i++){
            int ultPar = find(parent[i]) ;
            map.putIfAbsent(ultPar , Integer.MAX_VALUE);
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            int ultParU = find(u);
            int ultParV = find(v);
            map.put(ultParU , map.get(ultParU)&wt);
            map.put(ultParV , map.get(ultParV)&wt);
        }


        int q = queries.length ;
        int[] res = new int[q];
        for(int i = 0 ; i < q ; i++){
            int[] query = queries[i] ;
            int u = query[0];
            int v = query[1];
            int ans = 0 ; 
            if(find(u) != find(v)){
                ans = -1 ; 
            }else{
                ans = map.get(find(u));
            }
            res[i] = ans ;
        }
        return res ; 
    }
}
}
