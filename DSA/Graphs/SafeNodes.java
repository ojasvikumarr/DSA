package Graphs;
import java.util.* ;
public class SafeNodes {
    //Terminal node is a one that has zero outgoing edges
    //Safe node is one where all its path ends on a terminal node 
    //approach
    //To use detection of cycle as primary goal 
    //If theres a cycle existing then those nodes can never be a safe node 
    //we will take help of pathVis array and a check array which will keep in mind the 
    //no. of safe nodes 
    //Code will be similar to that of the detection of cycle in directed graph 
    public boolean DFS(int i , int[] vis , int[] pathVis , int[] check , List<List<Integer>> adj){
        vis[i] = 1 ;
        pathVis[i] = 1 ;
        check[i] = 0 ;
        for(int it : adj.get(i)){
            if(pathVis[it] == 1){
                return true ;
            }
            else if(vis[it] == 0){
                if(DFS(it, vis, pathVis, check, adj)){
                    return true ;
                }
            }
        }
        pathVis[i] = 0 ;
        check[i] = 1;
        return false ;
    }
    public List<Integer> eventualSafeNodes(int V , List<List<Integer>> adj){
        int vis[] = new int[V];
        int pathVis[] = new int[V];
        int check[] = new int[V];
        for(int i = 0; i < V ;i++){
            if(vis[i] == 0){
                DFS(i, vis, pathVis, check, adj);
            }
        }
        List<Integer> safeNodes = new ArrayList<>();
        for(int i = 0 ; i < V ; i++){
            if(check[i] == 1){
                safeNodes.add(i);
            }
        }
        return safeNodes ;
    }
}
