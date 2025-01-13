package Graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList ;
public class ParallelCoursesIII {
    class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        // Build adjacency list and indegree array
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        int[] indegree = new int[n];
        for (int[] relation : relations) {
            int u = relation[0] - 1;
            int v = relation[1] - 1;
            adjList.get(u).add(v);
            indegree[v]++;
        }
        
        // Kahn's algorithm with a DP array to store completion times
        Queue<Integer> q = new LinkedList<>();
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
                dp[i] = time[i];
            }
        }
        
        int result = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int neighbor : adjList.get(curr)) {
                indegree[neighbor]--;
                dp[neighbor] = Math.max(dp[neighbor], dp[curr] + time[neighbor]);
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
            result = Math.max(result, dp[curr]);
        }
        
        return result;
    }

    public int minimumTimeII(int n, int[][] relations, int[] time) {
        //Kahn algo 
        //Every level we will add the max month node to the ans 
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) adjList.add(new ArrayList<>());
        int[] indegree = new int[n];
        for(int[] relation : relations){
            int u = relation[0]-1;
            int v = relation[1]-1;
            adjList.get(u).add(v);
            indegree[v]++ ;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        int result = 0 ; 
        List<int[]> endNodes = new ArrayList<>();
        while(!q.isEmpty()){
            int size = q.size();
            int maxi = 0 ; 
            for(int i = 0 ; i < size ; i++ ){
                int curr = q.poll();
                boolean hasNeighbor = false ; 
                for(Integer neighbor : adjList.get(curr)){
                    indegree[neighbor]--;
                    hasNeighbor = true ;
                    if(indegree[neighbor] == 0){
                        q.add(neighbor);
                    }
                }
                if(hasNeighbor) maxi = Math.max(maxi , time[curr]);
                else endNodes.add(new int[]{curr , time[curr]});
            }
            List<int[]> dummy = new ArrayList<>();
            for(int[] pair : endNodes){
                int node = pair[0];
                int t = pair[1];
                t -= maxi ; 
                if(t > 0){
                    dummy.add(new int[]{node , t});
                }
            }
            endNodes = dummy ;
            result += maxi ;
        }
        int maxi = 0 ; 
        for(int[] pair : endNodes){
            int node = pair[0];
            int t = pair[1];
            maxi = Math.max(maxi , t);
        }
        result += maxi ;
        return result ;
    }

}
}
