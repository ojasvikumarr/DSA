package Graphs;

import java.util.Arrays;

public class NetworkDailySignal {
    class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n+1];
        Arrays.fill(dist , (int)1e8);
        dist[k] = 0 ;
        int mini = Integer.MIN_VALUE ;
        for(int i = 0 ; i < n ; i++){
            for(int[] time : times){
                int src = time[0];
                int dest = time[1];
                int wt = time[2];
                if(dist[src] + wt < dist[dest]){
                    dist[dest] = dist[src] + wt;
                }
            }
        }
        for(int i = 1 ; i < n+1 ; i++){
            if(i== k) continue;
            mini = Math.max(mini , dist[i]);
        }
        return mini == (int)1e8 ? -1 : mini;
        
    }
}
}
