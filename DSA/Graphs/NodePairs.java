package Graphs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NodePairs {
    class Solution {

    public int[] countPairs(int n, int[][] edges, int[] queries) {
        int[] degree = new int[n];
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int[] ed : edges) {
            degree[--ed[0]] ++;
            degree[--ed[1]] ++;
            if (ed[0] > ed[1]) {
                int temp = ed[0];
                ed[0] = ed[1];
                ed[1] = temp;
            }
			// store the number of edges for each node pair
            cnt.put(ed[0] * 20000 + ed[1], cnt.getOrDefault(ed[0] * 20000 + ed[1], 0) + 1);
        }
        
        int[] sorted = degree.clone();
        Arrays.sort(sorted);
        
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            int ans = 0;            
			// using two pointers to find how many potential node pairs
            for (int l = 0, r = sorted.length - 1; l < r;) {
                if (sorted[l] + sorted[r] > queries[i]) {
                    ans += (r - l);
                    r --;
                }
                else {
                    l ++;
                }
                
            }
            
			// remove all invalid pairs
            for (int k : cnt.keySet()) {
                int fi = k / 20000;
                int se = k % 20000;
                if (degree[fi] + degree[se] > queries[i] && degree[fi] + degree[se] - cnt.get(k) <= queries[i])
                    ans --;
            }
            
            res[i] = ans;
        }
        return res;
    }

    public int[] countPairsII(int n, int[][] edges, int[] queries) {
        int[] indegree = new int[n+1];
        boolean[][] isConnection = new boolean[n+1][n+1];
        Map<Integer , Integer> edgeCount = new HashMap<>();
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            indegree[u]++ ;
            indegree[v]++ ;
            isConnection[u][v] = true ;
            isConnection[v][u] = true ;
            int key = Math.min(u , v)*(n+1)+Math.max(u , v);
            edgeCount.put(key , edgeCount.getOrDefault(key , 0)+1);
        }
        int x =0 ; 
        int[] ans = new int[queries.length];
        for(Integer query : queries){
            int threshold = query ;
            int counter = 0 ; 
            for(int i = 1 ; i <= n ; i++){
                for(int j = i+1 ; j <= n ; j++){
                    int sum = indegree[i] + indegree[j];
                    int key = i*(n+1)+j ;
                    if(edgeCount.containsKey(key)){
                        sum -= edgeCount.get(key);
                    }
                    if(sum > threshold){
                        counter++ ;
                    }
                }
            }
            ans[x++] = counter ; 
        }
        return ans ;
    }
}
}
