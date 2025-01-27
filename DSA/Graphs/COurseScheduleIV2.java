package Graphs;

import java.util.ArrayList;
import java.util.List;

public class COurseScheduleIV2 {
    class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] edges, int[][] queries) {
        //Lets first do this with the straight graph 
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
        }
        List<Boolean> result = new ArrayList<>();
        for(int[] query : queries){
            int src = query[0];
            int end = query[1];
            boolean[] vis = new boolean[n];
            if(dfs(graph , src , end , vis)){
                result.add(true);
            }else{
                result.add(false);
            }
        }
        return result ; 
    }
    public boolean dfs(List<List<Integer>> graph , int src , int dest , boolean[]visited){
        if(src == dest){
            return true ;
        }
        visited[src] = true ; 
        for(Integer neighbor : graph.get(src)){
            if(visited[neighbor] == false && dfs(graph , neighbor , dest , visited)){
                return true ;
            }
        }
        return false ;
    }
}
}
