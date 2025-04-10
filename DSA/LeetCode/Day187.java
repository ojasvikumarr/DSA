package LeetCode;

import java.util.Arrays;

public class Day187 {
    class Solution {
    long[][] dp ; 
    public long numberOfPowerfulInt(long start, long finish, int limit, String suff) {
        dp = new long[17][2];
        for(long[] row : dp) Arrays.fill(row ,-1);

        String s = String.valueOf(start-1);
        String f = String.valueOf(finish);

        long ansSmall = 0 ; 
        long ansLarge = 0 ; 
        if(s.length() >= suff.length()){
            ansSmall = solve(s , 0 , true , limit , suff);
        }
        for(long[] row : dp) Arrays.fill(row ,-1);
        if(f.length() >= suff.length()){
            ansLarge = solve(f , 0 , true , limit , suff);
        }
        return ansLarge - ansSmall ; 
    }

    public long solve(String s, int idx , boolean tight , int limit , String Suffix){
        if(idx == s.length() - Suffix.length()){
            String checkSubStr = s.substring(s.length() - Suffix.length());
            return tight ? (checkSubStr.compareTo(Suffix) >= 0 ? 1 : 0 ) : 1; 
        }

        int flag = tight ? 1 : 0 ;
        if(dp[idx][flag] != -1){
            return dp[idx][flag] ;
        }

        int cap = tight ? Math.min(s.charAt(idx) - '0' , limit) : limit ;
        long ans = 0 ; 
        for(int i = 0 ; i <= cap ; i++){
            ans += solve(s , idx+1 , tight && (i == s.charAt(idx) - '0') , limit , Suffix) ; 
        }
        return dp[idx][flag] = ans ; 
    }
}
}
