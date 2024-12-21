package Graphs;

import java.util.Arrays;

public class IntegerBreak {
    class Solution {
    int[] dp ;
    public int integerBreak(int n) {
        dp = new int[n+1];
        Arrays.fill(dp , -1);
        return solve(n);
    }
    public int solve(int n) {
        if(n == 1 || n == 0 ) return 1 ;
        if(dp[n] != -1) return dp[n];
        int result = Integer.MIN_VALUE ;
        for(int i = 1 ; i < n ; i++){
            // if(n-i > 0)
            int prod = i*Math.max(n-i ,solve(n-i));
            result = Math.max(result , prod);
        }
        return dp[n] = result;
    }
}
}
