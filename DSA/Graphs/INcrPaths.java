package Graphs;

import java.util.Arrays;

public class INcrPaths {
    class Solution {
    int MOD = (int)1e9 + 7 ; 
    int[][] dp;
    public int countPaths(int[][] grid) {
        int n = grid.length ; 
        int m = grid[0].length ; 
        dp = new int[n][m];
        for(int[] row : dp) Arrays.fill(row , -1);
        int result = 0 ; 
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                result = (result + solve(grid , i , j , -1))%MOD;
            }
        }
        return result ; 
    }
    public int solve(int[][] grid , int i , int j , int prev){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] <= prev){
            return 0 ; 
        }
        if(dp[i][j] != -1) return dp[i][j];

        int left = solve(grid , i , j-1 , grid[i][j]);
        int right = solve(grid , i , j+1 , grid[i][j]);
        int up = solve(grid , i-1 , j , grid[i][j]);
        int down = solve(grid , i+1 , j , grid[i][j]);

        return dp[i][j] = (1 + left + right + up + down)%MOD ; 
    }
}
}
