package Graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.* ;

public class EdgeReversal {
    class Solution {
    public int minReorder(int n, int[][] connections) {
        //Undirected graph
        List<List<Integer>> adjList = new ArrayList<>();
        //directed graph
        List<List<Integer>> checkList = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            adjList.add(new ArrayList<>());
            checkList.add(new ArrayList<>());
        }

        for(int[] connection : connections){
            int u = connection[0];
            int v = connection[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
            checkList.get(v).add(u);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        boolean[] visited = new boolean[n];
        visited[0] = true ;

        int reversal = 0 ; 

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                int src = q.poll();
                for(Integer neighbor : adjList.get(src)){
                    if(!visited[neighbor]){
                        visited[neighbor] = true ;
                        if(!checkList.get(src).contains(neighbor)) reversal++ ; 
                        q.add(neighbor);
                    }
                }
            }
        }
        return reversal ;
    }
}
}
