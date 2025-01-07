package DynamicProgramming;

import java.util.Arrays;

public class NonNegConcOne {
    class Solution {
    public int findIntegers(int n) {    
        int[] f= new int[32];
        f[0] = 1; 
        f[1] = 2 ; 
        for(int i = 2; i < f.length ; i++){
            f[i] = f[i-1] + f[i-2];
        }
        int i = 30 ; // Because the constraints are n <= 10^9 which is just less that 2^30 
        int sum = 0 ; 
        int prevBit = 0 ; 
        while(i-- >= 0){
            if((n & (1 << i)) != 0){
                //this means that in number the ith bit is set to 1 
                sum += f[i];
                if(prevBit == 1){
                    sum-- ;
                    break ;
                }
                //Now for next iteration the prevBit is set to 1 
                prevBit = 1 ;
            }else{
                //The bit was not set so we removed the prevBit 
                prevBit = 0 ;
            }
        }
        return sum + 1 ;
    }

//I tried digit DP on this but failed never mind you always learn something!!!
    int[] dp ;
    public int findIntegersII(int n) {
        String bin = Integer.toBinaryString(n);
        int bits = bin.length();
        // double logBase2 = Math.log(n)/Math.log(2);
        // int bits = (int)Math.ceil(logBase2) + 1;
        dp = new int[bits];
        System.out.println(bits);
        Arrays.fill(dp , -1);
        return solve(0 , bits);
    }
    public int solve(int idx , int n){
        if(idx >= n) return 1 ;
        // else if(idx > n) return 0 ; 
        if(dp[idx] != -1) return dp[idx];
        int pick = solve(idx+2 , n);
        int notpick = solve(idx+1 , n);
        return dp[idx] = pick + notpick ;
    }
    // public int solveII(String s , int idx , int cnt , boolean tight){
    //     if(idx == s.length()) return cnt ; 
    //     int limit = tight ? 0 : 1 ; 
    //     int ans = 0 ;
    //     for(int i = 0 ; i <= limit ; i++){
    //         ans += solveII(s , idx+1 , cnt);
    //     }
    // }
}
}
