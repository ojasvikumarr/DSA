package Graphs;

import java.util.List;

public class KeyRooms {
    class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int V = rooms.size();
        boolean[] visited = new boolean[V] ; 
        dfs(rooms , 0 , visited);
        for(int i = 0 ; i <V ; i++){
            if(!visited[i]) return false ;
        }
        return true ; 
    }
    public void dfs(List<List<Integer>> rooms , int src, boolean[] visited){
        visited[src] = true ; 
        for(Integer neighbor : rooms.get(src)){
            if(!visited[neighbor]){
                dfs(rooms , neighbor , visited);
            }
        }
    }
}
}
