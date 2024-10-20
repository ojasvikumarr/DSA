package Graphs;
import java.util.* ;
public class isBipartiteDFS {
    public boolean DFS(int i , int col , int[] color , ArrayList<ArrayList<Integer>> graph){
        color[i] = col ;
        for(int it : graph.get(i)){
            if(color[it] == -1){
                if(DFS(it, 1-col, color, graph) == false){
                    return false ;
                }
                else if(color[it] == col){
                    return false ;
                }
            }
        }
        return true ;
    }
    public boolean bipartite(int V , ArrayList<ArrayList<Integer>> graph){
        int color[] = new int[V];
        for(int i = 0 ; i < V ; i++){
            color[i] = -1 ;
        }
        for(int i = 0 ; i < V ; i++){
            if(color[i] == -1){
                if(!DFS(i, V, color, graph)){
                    return false ;
                }
            }
        }
        return true ;
    }
}
