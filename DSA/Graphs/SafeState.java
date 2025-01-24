package Graphs;

import java.util.ArrayList;
import java.util.List;

public class SafeState {
    class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        //First we find cycle in the graph 
        int n = graph.length ; 
        boolean[] visited = new boolean[n];
        boolean[] parVis = new boolean[n];

        List<Integer> redMarked = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
                if(!isCycle(graph , i , visited , parVis)){
                    redMarked.add(i);
                }
        }
        return redMarked ;
        // //Now we will be doing Kahn Algo
        // int[] indegree = new int[n];
        // for(int i =)

    }
    public boolean isCycle(int[][] graph , int src , boolean[] visited , boolean[] parVis ){
        visited[src] = true ;
        parVis[src] = true ; 
        for(Integer neighbor : graph[src]){
            if(parVis[neighbor] == true ){
                return true ;
            }else if(visited[neighbor] == false && isCycle(graph , neighbor , visited , parVis)){
                return true;
            }
        }
        parVis[src] = false ; 
        return false ;
    }

}
}
