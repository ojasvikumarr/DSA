package DynamicProgramming;

public class UniquePATHSII {
    class Solution {
        public int uniquePathsWithObstacles(int[][] dp) {
            int m = dp.length ;
            int n = dp[0].length ;
            if(dp[m-1][n-1] == 1 || dp[0][0] == 1) return 0 ;
            for(int i = 0 ; i < m ; i++){
                for(int j = 0 ; j < n ; j++){
                    if(dp[i][j] == 1) dp[i][j] = -1 ;
                }
            }
            dp[m-1][n-1] = 1 ;
            for(int i = m-1 ; i >= 0 ; i--){
                for(int j = n-1 ; j >= 0 ; j--){
                    if(dp[i][j] == -1 || (i == m-1 && j == n-1)) continue ;
                    int down = (i+1 < m && dp[i+1][j] != -1) ? dp[i+1][j] : 0 ;
                    int right = (j+1 < n && dp[i][j+1] != -1) ? dp[i][j+1] : 0 ;
                    dp[i][j] = down + right ;
                }
            }
            return dp[0][0] ;
        }
    }
}
