package DynamicProgramming;

import java.util.Arrays;

public class MinCostClimbingStairs {
    class Solution {
    int[] dp ; 
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length ;
        int[] tab = new int[n+1];
        tab[n] = 0 ; 
        tab[n-1] = cost[n-1];
        for(int idx = n-2 ; idx >= 0 ; idx--){
            tab[idx] = cost[idx] + Math.min(tab[idx+2] , tab[idx+1]);
        }
        return Math.min(tab[0] , tab[1]);
    }
    public int minCostClimbingStairsII(int[] cost) {
        int n = cost.length ;
        dp = new int[n];
        Arrays.fill(dp , -1);
        dp[n] = cost[n-1];
        dp[n-1] = cost[n-2];
        for(int idx = n-2 ; idx >= 0 ; idx--){
            dp[idx] = cost[idx] + Math.min(dp[idx+1] , dp[idx+2]);
        }
        return Math.min(solve(cost , 0) , solve(cost , 1));
    }
    public int solve(int[] cost , int idx ){
        if(idx >= cost.length){
            return 0 ; 
        }
        if(dp[idx] != -1){
            return dp[idx] ; 
        }
        int pick = cost[idx] + Math.min(solve(cost , idx+1) , solve(cost , idx+2));
        return dp[idx] = pick ; 
    }
}
}
