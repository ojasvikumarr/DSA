package LeetCode;

import java.util.Arrays;

public class Day179 {
    class Solution {
    long[] dp ;
    public long mostPoints(int[][] questions) {
        int n = questions.length ; 
        dp = new long[n] ;
        Arrays.fill(dp , -1);
        // return solve(questions , 0);
        return tabulation(questions);
    }
    public long tabulation(int[][] arr){
        int n = arr.length ; 
        long[] dp = new long[n+1];
        dp[n] = 0 ; 
        for(int i = n-1 ; i >= 0 ; i--){
            long pick = arr[i][0] + ((i + arr[i][1] + 1) < n ?  dp[i + arr[i][1] + 1] : 0 );
            long notpick = dp[i+1];
            dp[i] = Math.max(pick , notpick);
        }
        return dp[0];
    }
    public long solve(int[][] arr , int idx){
        if(idx >= arr.length){
            return 0 ; 
        }
        if(dp[idx] != -1) return dp[idx];
        //what do i have 
        /// either i pick 
        long pick = arr[idx][0] + solve(arr , idx+arr[idx][1]+1);
        /// or i not pick 
        long notpick = solve(arr , idx+1);
        return dp[idx] = Math.max(pick , notpick);
    }
}
}
