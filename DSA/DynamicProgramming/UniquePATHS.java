package DynamicProgramming;

import java.util.Arrays;

public class UniquePATHS {
    class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int[] row : dp) Arrays.fill(row , -1);
        dp[m-1][n-1] = 1 ;
        for(int i = m-1 ; i >= 0 ; i--){
            for(int j = n-1 ; j >= 0 ; j--){
                if(i == m-1 && j == n-1) continue ;
                int down = (i+1 < m ) ? dp[i+1][j] : 0;
                int right = (j+1 < n) ? dp[i][j+1] : 0;
                dp[i][j] = down + right ;
            }
        }
        return dp[0][0];
    }
    public int recur(int i , int j , int m , int n , int[][] dp){
        if(i == m && j == n) return 1 ;
        if(i > m || j > n) return 0 ; 
        if(dp[i][j] != -1) return dp[i][j];
        int right = recur(i , j+1 , m , n , dp);
        int down = recur(i+1 , j , m , n , dp);
        return dp[i][j] = right + down ;
    }
}
}
