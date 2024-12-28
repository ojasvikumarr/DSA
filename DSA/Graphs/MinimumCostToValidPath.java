package Graphs;

import java.util.Arrays;
import java.util.Queue;
import java.util.* ;

public class MinimumCostToValidPath {
    class Solution {
    //tis is all the directions 
    int[][] dir = new int[][] {{0 , 1} , {0 , -1} , {1 , 0} , {-1 , 0}};
    public int minCost(int[][] grid) {
        int m = grid.length ; 
        int n = grid[0].length ; 
        int cost = 0 ;
        //memoization
        int[][] dp = new int[m][n];
        for(int i = 0 ; i < m ;i++) Arrays.fill(dp[i] , Integer.MAX_VALUE);
        // queue for BFS 
        Queue<int[]> bfs = new LinkedList<>();
        //Applying DFS from origin
        dfs(grid , 0 , 0 ,dp , cost , bfs);
        while(!bfs.isEmpty()){
            cost++ ; 
            int size = bfs.size();
            for(int j = 0 ; j < size ; j++){
                int[] top = bfs.poll();
                int r = top[0] , c = top[1];
                for(int i = 0 ; i < 4 ; i++){
                    dfs(grid , r + dir[i][0] , c + dir[i][1] , dp , cost , bfs);
                }
            }
        }
        return dp[m-1][n-1];
    }
    public void dfs(int[][] grid , int r , int c , int[][] dp , int cost , Queue<int[]> bfs){
        int m = grid.length ; 
        int n = grid[0].length ; 
        if(r < 0 || r >= m || c < 0 || c >= n || dp[r][c] != Integer.MAX_VALUE) return ; 
        dp[r][c] = cost ; 
        bfs.offer(new int[]{r , c});
        int nextDir = grid[r][c] - 1 ;
        dfs(grid , r + dir[nextDir][0] , c + dir[nextDir][1] , dp , cost , bfs);
    }
}
}
