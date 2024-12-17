package Graphs;

import java.util.ArrayList;
import java.util.List;

public class VariousPaths {
    class Solution {
    List<List<Integer>> ans ;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ans = new ArrayList<>();
        int V = graph.length ;
        boolean[] visited = new boolean[V];
        // boolean[] pathVis = new boolean[V];
        dfs(graph , 0 , V-1 , visited , new ArrayList<>());
        return ans ;
    }
    public void dfs(int[][] graph , int src , int dest , boolean[] visited , List<Integer> path){
        visited[src] = true ; 
        // pathVis[src] = true ;
        path.add(src);
        if(src == dest){
            ans.add(new ArrayList<>(path));
        }
        for(Integer neighbor : graph[src]){
            if( !visited[neighbor]){
                dfs(graph , neighbor , dest , visited , path);
            }
        }
        path.remove(path.size()-1);
        visited[src] = false ;
    }
}
}
