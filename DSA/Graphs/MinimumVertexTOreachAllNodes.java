package Graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.* ; 

public class MinimumVertexTOreachAllNodes {
    class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> result = new ArrayList<>();
        int[] indegree = new int[n];
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) adjList.add(new ArrayList<>());

        for(List<Integer> edge : edges){
            int u = edge.get(0);
            int v = edge.get(1);
            adjList.get(u).add(v);
            indegree[v]++ ;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            if(indegree[i] == 0){
                q.add(i);
                result.add(i);
            }
        }

        // boolean[] visited = new boolean[n];

        // while(!q.isEmpty()){
        //     int size = q.size();
        //     for(int i = 0 ; i < size ; i++){
        //         int curr = q.poll();
        //         for(Integer neighbor : adjList.get(curr)){
        //             indegree-- ;
        //             if(indegree == 0 && !visited[neighbor]){
        //                 visited[neighbor] = true ;
        //                 q.add(neighbor);
        //             }
        //         }
        //     }
        // }

        //Now we need to check for the unvisited edges 
        return result ;
    }
}
}
