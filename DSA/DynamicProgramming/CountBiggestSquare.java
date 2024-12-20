package DynamicProgramming;

public class CountBiggestSquare {
    class Solution {
        public int maximalSquare(char[][] matrix) {
            int n = matrix.length ; 
            int m = matrix[0].length ;
            int[][] dp = new int[n][m];
            int maxi = 0 ;
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < m ; j++){
                    //This commented code was causing the problem in solution!!!!!!!
                    //Matrix is of char thus maxi was getting 48 value instead of 0 
                    dp[i][j] = matrix[i][j] == '1' ? 1 : 0;
                    // maxi = Math.max(maxi , matrix[i][j]);
                    // dp[i][j] = matrix[i][j] - '0';
                    if(dp[i][j] == 1) maxi = 1; 
                }
            }
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < m ; j++){
                    if(i-1 < 0 || j-1 < 0)continue ;
                
                    if(dp[i][j] == 1){
                        dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j] , dp[i][j-1]) , dp[i-1][j-1]);
                        maxi = Math.max(maxi , dp[i][j]);
                    }
                }
            }
            return maxi*maxi;
    
        }
    }
}
