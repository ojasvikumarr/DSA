package Graphs;

import java.util.Queue;
import java.util.LinkedList ;
public class BitManiGraph {
    class Solution {
    public int shortestPathLength(int[][] graph) {
        int V = graph.length ; 
        if(V == 1) return 0 ; 
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0 ; i < V ; i++){
            q.add(new int[]{i , 1<<i});
        }
        int finalState = (1<<V )-1 ;
        int shortestPath = 0 ; 
        int[][] visitedMap = new int[V][finalState+1];
        while(!q.isEmpty()){
            int size = q.size();
            shortestPath++ ;
            for(int i = 0 ; i < size ; i++){
                int[] head = q.poll();
                int node = head[0];
                int bit = head[1];
                for(Integer neighbor : graph[node]){
                    int newBit = bit | 1 << neighbor ;
                    if(visitedMap[neighbor][newBit] == 1) continue ;
                    visitedMap[neighbor][newBit] = 1 ;
                    if(newBit == finalState) return shortestPath ;
                    q.add(new int[]{neighbor , newBit});
                }
            }
        }
        return -1 ;
    }
}
}
