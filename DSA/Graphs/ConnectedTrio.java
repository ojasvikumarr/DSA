package Graphs;

public class ConnectedTrio {
    class Solution {
        public int minTrioDegree(int n, int[][] edges) {
            //We'll be calculating the indegrees for every vertex 
            int[] indegree = new int[n+1];
            boolean[][] isConnected = new boolean[n+1][n+1];
            for(int[] edge : edges){
                indegree[edge[0]]++ ;
                indegree[edge[1]]++ ;
                isConnected[edge[0]][edge[1]] = true ;
                isConnected[edge[1]][edge[0]] = true ;
            }
            //Now we need to make pairs that form connected trios
            int mini = Integer.MAX_VALUE ;
            for(int[] edge : edges){
                for(int i = 1 ; i <= n ; i++){
                    if(isConnected[i][edge[0]] && isConnected[i][edge[1]]){
                        int allDegrees = indegree[i] + indegree[edge[0]] + indegree[edge[1]] - 6 ; 
                        mini = Math.min(mini , allDegrees);
                    }
                }
            }
            return mini == Integer.MAX_VALUE ? -1 : mini ;
        }
    }
}
