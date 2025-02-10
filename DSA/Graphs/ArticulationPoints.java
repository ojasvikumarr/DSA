package Graphs;
import java.util.*  ;

public class ArticulationPoints {
    int timer = 0 ; 
    public void dfs(List<List<Integer>> graph ,int curr , int parent,  int[] dist , int[] low , boolean[] vis , int[] articulation){
        vis[curr] = true ; 
        dist[curr] = low[curr] = timer++ ; 
        int child = 0 ; 
        for(Integer neighbor : graph.get(curr)){
            if(neighbor == parent) continue ;
            if(vis[neighbor] == false){
                dfs(graph, neighbor , curr, dist, low, vis, articulation);
                low[curr] = Math.min(low[curr] , low[neighbor]);
                if(low[neighbor] >= dist[curr] && parent != -1){
                    articulation[curr] = 1 ;
                }
                child++ ;
            }else{
                low[curr] = Math.min(low[curr] , dist[neighbor]);
            }
        }
        if(parent == -1 && child > 0){
            articulation[curr] = 1 ; 
        
    }

}
