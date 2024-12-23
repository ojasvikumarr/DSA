package DynamicProgramming;
import java.util.Arrays ;
public class GuessNumber {
    class Solution {
        int[][] dp ;
        public int getMoneyAmount(int n) {
            dp = new int[n+1][n+1];
            for(int[] row : dp)
            Arrays.fill(row , -1);
            return solve(1 , n);
        }
        public int solve(int start , int end){
            if(start >= end) return 0 ; 
            if(dp[start][end] != -1) return dp[start][end];
    
            int ans = Integer.MAX_VALUE ;
            for(int i = start ; i <= end ; i++){
                ans = Math.min(ans , i + Math.max(solve(start , i-1) ,solve(i+1 , end)));
            }
            return dp[start][end] = ans ;
        }
    }
}

