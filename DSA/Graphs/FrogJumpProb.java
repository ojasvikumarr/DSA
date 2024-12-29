package Graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.* ; 

public class FrogJumpProb {
    class Solution {
    // class Pair{
    //     int src ; 
    //     int timeleft ; 
    //     double probability ;
    //     public Pair(int s, int t , double p){
    //         this.src = s ; 
    //         this.timeleft = t ; 
    //         this.probability = p ; 
    //     }
    // }
    public double frogPosition(int n, int[][] edges, int t, int target) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0 ; i <= n ; i++) adjList.add(new ArrayList<>());
        for(int[] edge : edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        // q.add(new Pair(1 , t , 1));
        q.add(1);
        double[] prob = new double[n+1] ;
        prob[1] = 1.0 ;

        boolean[] visited = new boolean[n+1];
        visited[1] = true ;

        while(!q.isEmpty() && t-- > 0){
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                // Pair p = q.poll();
                // int src = p.src ; 
                // int time = p.timeleft ; 
                // double prob = p.probability ;
                int src = q.poll();
                // if(src == target){
                //     if(time == 0 || adjList.get(src).stream().allMatch(neighbor -> visited[neighbor])){
                //     // if(time == 0){
                //         return prob ; 
                //     }
                //     return 0.0 ;
                // }
                int neighbors =0 ; 
                for(Integer neighbor : adjList.get(src)){
                    if(visited[neighbor] == false) neighbors++ ;
                }
                for(Integer neighbor : adjList.get(src)){
                    if(!visited[neighbor]){
                        visited[neighbor] = true ;
                        // q.add(new Pair(neighbor , time-1 , (double)(prob/neighbors)));
                        q.add(neighbor);
                        prob[neighbor] = prob[src]/neighbors;
                    }
                }
                if(neighbors > 0) prob[src] = 0 ;
            }
        }
        return prob[target] ;
    }
}
}
