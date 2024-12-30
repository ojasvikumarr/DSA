package LeetCode;

import java.util.Arrays;

public class Day86 {
    class Solution {
    int[] dp;
    int mod = 1000000007 ;
    public int countGoodStrings(int low, int high, int zero, int one) {
        dp = new int[high + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1 ;
        // signifies onew way is to have an empty string
        int answer = 0 ;

        for(int len = low ; len <= high ; len++){
            //calculating all possible strings of length len 
            answer += solve(len , zero , one);
            answer %= mod ;
        }
        return answer%mod ; 
    }

    public int solve(int length, int zero, int one) {
        if(length < 0) return 0 ;
        if(dp[length] != -1) return dp[length] ;
        
        int count = 0 ;
        // Zero operation
        // int zeroOp = solve(limit, zero, one, sum + zero) + 1;
        if(length >= zero)
            count += solve(length-zero , zero , one) % mod;
        // One operation
        // int oneOp = solve(limit, zero, one, sum + one) + 1;
        if(length >= one)
            count += solve(length-one , zero , one) % mod;

        return dp[length] = count%mod ;
    }
}
}
