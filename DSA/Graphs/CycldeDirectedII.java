package Graphs;
import java.util.* ;

public class CycldeDirectedII {
    public boolean DFS(int node , int[] vis , int[] pathVis , ArrayList<ArrayList<Integer>> graph){
        vis[node] = 1 ;
        pathVis[node] = 1 ;
        for(int it : graph.get(node)){
            if(vis[it] == 0){
                if(DFS(it, vis, pathVis, graph)){
                    return true ;
                }
            }else if(vis[it] == 1){
                return true ;
            }
        }
        pathVis[node] = 0 ;
        return false ;
    }
    public boolean isCyclic(int V , ArrayList<ArrayList<Integer>> adj){
        int vis[] = new int[V];
        int pathVis[] = new int[V];
        for(int i = 0 ; i < V ; i++){
            if(vis[i] == 0){
                if(DFS(i , vis , pathVis , adj) == true){
                    return true ;
                }
            }
        }
        return false ;
    }
}
