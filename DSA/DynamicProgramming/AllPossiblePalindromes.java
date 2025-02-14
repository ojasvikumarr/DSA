package DynamicProgramming;

import java.util.Arrays;

public class AllPossiblePalindromes {
    class Solution {
    int MOD = (int)1e9 + 7 ; 
    int[][][] memo ; 
    String s; 
    public int countPalindromicSubsequences(String S) {
        s = S ; 
        int ans = 0 ; 
        int n = s.length();

        memo = new int[n+1][n+1][4];
        for(int[][] mat : memo){
            for(int[] row : mat){
                Arrays.fill(row , -1);
            }
        }

        for(int i = 0 ; i < 4 ; i++){
            ans = (ans + dp(0 , s.length()-1 , i)%MOD )% MOD ; 
        }

        return ans%MOD ;
    }
    public int dp(int start , int end , int alpha){
        if(start > end) return 0 ; 
        if(start == end){
            if(s.charAt(start) == alpha+'a'){
                return 1 ; 
            }else{
                return 0 ; 
            }
        }

        if(memo[start][end][alpha] != -1) return memo[start][end][alpha];
        char sStart = s.charAt(start);
        char sEnd = s.charAt(end);
        char alphabet = (char)(alpha + 'a');

        int dev = 0 ; 

        if(sStart == sEnd && sStart == alphabet){
            dev = 2 ; 
            for(int i = 0 ; i < 4 ; i++){
                dev = (dev + dp(start+1 , end-1 , i)% MOD) % MOD ; 
            }
        }else{
            dev = (dev + dp(start , end-1 , alpha)%MOD)% MOD ; 
            dev = (dev + dp(start+1 , end , alpha)%MOD)% MOD ; 
            dev = (dev - dp(start+1 , end-1 , alpha)%MOD)% MOD ;
            if(dev < 0){
                dev += MOD ; 
            }
        }

        memo[start][end][alpha] = dev ; 
        return dev ; 
    }
    // public int countPalindromicSubsequencesII(String s) {
    //     StringBuilder t = new StringBuilder(s);
    //     t.reverse();
    //     int MOD = (int)1e9 + 7 ;

    //     int n = s.length();
    //     int[][] dp = new int[n+1][n+1];

    //     int ans = 0 ; 
    //     for(int i = 1; i < n; i++){
    //         for(int j = 1 ; j < n; j++){
    //             if(s.charAt(i-1) == t.charAt(j-1)){
    //                 dp[i][j] = 1 + dp[i-1][j-1];
    //             }else{
    //                 dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
    //             }
    //             ans = (ans + dp[i][j] + MOD)%MOD; 
    //         }
    //     }

    //     return ans%MOD ;
    // }
}
}
