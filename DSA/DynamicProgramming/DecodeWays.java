package DynamicProgramming;

import java.util.Arrays;

public class DecodeWays {
    class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0) == '0') return 0 ;
        int[] dp = new int[s.length()];
        Arrays.fill(dp , -1);
        return helper(0 , s , dp);
    }
    // public int recur(int idx , String str){
    //     if(idx == str.length()) return 1 ;
    //     else if( idx > str.length()) return 0 ;
    //     // if(str.charAt(idx+1) == '0') return 0 ;
    //     int pickOne = idx < str.length() && str.charAt(idx) != '0' ?recur(idx+1 , str) : 0;

    //     int pickTwo = idx+1 < str.length() && (Integer.valueOf(str.substring(idx , idx+2)) < 27) && str.charAt(idx) != '0' ? recur(idx+2 , str) : 0;

    //     return pickOne + pickTwo ;
    // }

    public int helper(int idx , String str , int[] dp){
        if(idx == str.length()) return 1 ; 
        if(str.charAt(idx) == '0') return 0 ;
        if(dp[idx] != -1) return dp[idx];

        int pickOne = helper(idx + 1 , str , dp);
        int pickTwo = 0 ; 
        if(idx + 1 < str.length() && Integer.valueOf(str.substring(idx , idx+2)) <= 26){
            pickTwo = helper(idx + 2 , str , dp);
        }
        dp[idx] = pickOne + pickTwo ;
        return dp[idx];
    }
}
}
