package DynamicProgramming;

public class LongestIncPathMatrix {
    class Solution {
        int maxi = 0 ;
        public int longestIncreasingPath(int[][] grid) {
            int n = grid.length ; 
            int m = grid[0].length ; 
            int[][] dp = new int[n][m];
            
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < m ;j++){
                    helper(grid , i , j , dp);
                }
            }
            return maxi ; 
        }
        public int helper(int[][] grid , int i , int j , int[][] dp){
            if(dp[i][j] != 0) return dp[i][j];
            int curr = 1 ; 
            int n = grid.length ; 
            int m = grid[0].length ; 
            if(i+1 < n && grid[i+1][j] > grid[i][j]){
                curr = Math.max(curr , 1 + helper(grid , i+1 , j , dp));
            }
            if(j+1 < m && grid[i][j+1] > grid[i][j]){
                curr = Math.max(curr , 1 + helper(grid , i , j+1 , dp));
            }
            if(i-1 >= 0 && grid[i-1][j] > grid[i][j]){
                curr = Math.max(curr , 1 + helper(grid , i-1 , j , dp));
            }
            if(j-1 >= 0 && grid[i][j-1] > grid[i][j]){
                curr = Math.max(curr , 1 + helper(grid , i , j-1 , dp));
            }
            maxi = Math.max(maxi , curr );
            dp[i][j] = curr ;
            return curr ;
        }
    }
}
