package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class ThreeDijsktra {
    class Solution {
    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        List<List<int[]>> graph = new ArrayList<>();
        List<List<int[]>> revGraph = new ArrayList<>();

        for(int i = 0 ; i < n ; i++) graph.add(new ArrayList<>());
        for(int i = 0 ; i < n ; i++) revGraph.add(new ArrayList<>());
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            graph.get(u).add(new int[]{v , wt});
            revGraph.get(v).add(new int[]{u , wt});
        }

        long[] distA = new long[n];
        long[] distB = new long[n];
        long[] distD = new long[n];
        Arrays.fill(distA , Long.MAX_VALUE);
        Arrays.fill(distB , Long.MAX_VALUE);
        Arrays.fill(distD , Long.MAX_VALUE);

        Dijsktra(graph , src1 , distA);
        Dijsktra(graph , src2 , distB);
        Dijsktra(revGraph , dest , distD);

        long ans = Long.MAX_VALUE ; 
        for(int i = 0 ; i < n ; i++){
            if(distA[i] == Long.MAX_VALUE || distB[i] == Long.MAX_VALUE || distD[i] == Long.MAX_VALUE) continue ; 
            ans = Math.min(ans , distA[i] + distB[i] + distD[i]);
        }
        return ans == Long.MAX_VALUE ? -1 : ans ;

    }
    public void Dijsktra(List<List<int[]>> graph , int src , long[] dist){
        PriorityQueue<long[]> pq = new PriorityQueue<>((a , b) -> Long.compare(a[1],b[1]));
        dist[src] = 0 ; 
        pq.add(new long[]{src , 0});

        while(!pq.isEmpty()){
            long[] curr = pq.poll();
            int u = (int)curr[0];
            long currDist = curr[1];
            if(currDist > dist[u]) continue ; 
            for(int[] nei : graph.get((int)u)){
                int v = nei[0];
                int wt = nei[1];
                if(dist[v] > wt + dist[u]){
                    dist[v] = wt + dist[u];
                    pq.add(new long[]{v ,dist[v] });
                }
            }
        }

        return ;
    }
}

}
